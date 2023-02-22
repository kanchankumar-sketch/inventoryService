package in.reinventing.inventory.controller;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reinventing.inventory.dto.ItemDTO;
import in.reinventing.inventory.dto.ItemStatus;
import in.reinventing.inventory.model.Category;
import in.reinventing.inventory.model.Inventory;
import in.reinventing.inventory.model.Item;
import in.reinventing.inventory.service.CategoryService;
import in.reinventing.inventory.service.InventoryService;
import in.reinventing.inventory.service.ItemService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/saveItem")
	public ResponseEntity<Object> saveItem(@RequestBody @Valid ItemDTO item){
		
		Inventory inventory=this.inventoryService.getInventoryById(item.getInventoryId());
		if(inventory==null) {
			return new ResponseEntity<Object>("Inventory not found.",HttpStatus.BAD_REQUEST);
		}		
		Long categoryId=item.getCatagoryId();
		Category category=this.categoryService.getCategoryById(categoryId);
		if(category!=null) {
			if(inventory.getCategories().contains(category)) {
				category.getItems().add(Item.builder().name(item.getName()).createdAt(Instant.now()).updatedAt(Instant.now()).quantities(item.getQuantities()).build());
				return new ResponseEntity<Object>(this.categoryService.saveCategory(category),HttpStatus.CREATED);
			}
			return new ResponseEntity<Object>("Category not found in this inventory.",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>("Category not found.",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public List<Inventory> getAllInformation() {
		return this.inventoryService.getAllInvetory();
	}
	
	@PostMapping("/save")
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		return this.inventoryService.saveInventory(inventory);
	}
	
	@GetMapping("/getItemStatus/{itemId}")
	public ItemStatus getItemStatus(@PathVariable("itemId") Long itemId) {
		Item item=this.itemService.getItemById(itemId);
		if(item!=null) {
			if(item.getQuantities()>0) {
				return ItemStatus.builder().inStock(true).items(item.getQuantities()).message("Item in Stock.").build();
			}else {
				return ItemStatus.builder().inStock(false).items(0L).message("Item not in Stock.").build();
			}
		}
		return ItemStatus.builder().inStock(false).items(0L).message("Item not found.").build();
	}
	
	@DeleteMapping("/deleteItem/{itemId}")
	public String removeItemStatus(@PathVariable("itemId") Long itemId) {
		Item item=this.itemService.getItemById(itemId);
		if(item!=null) {
			this.itemService.deleteById(itemId);
				return "Item deleted.";
		}
		return "Item not found.";
	}
		
}
