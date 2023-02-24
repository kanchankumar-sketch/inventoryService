package in.reinventing.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reinventing.inventory.dto.ItemDTO;
import in.reinventing.inventory.model.Category;
import in.reinventing.inventory.model.Item;
import in.reinventing.inventory.service.CategoryService;
import in.reinventing.inventory.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Item> getItems() {
		return this.itemService.findAll();
	}

	@GetMapping("/{id}")
	public Item getItem(@PathVariable("id") Long itemId) {
		return this.itemService.findById(itemId);
	}

	@PostMapping("/{categoryId}")
	public Item saveItem(@RequestBody @Valid ItemDTO itemDTO, @PathVariable("categoryId") Long categoryId) {

		Category category = this.categoryService.getCategoryById(categoryId);
		if (category != null) {
			Item item = new Item();
			item.setName(itemDTO.getName());
			item.setQuantities(itemDTO.getQuantities());
			item.setCategory(category);
			return this.itemService.saveItem(item);
		}
		return null;

	}
	
	@PutMapping("/{id}")
	public Item updateItem(@PathVariable("id") Long itemId,@RequestBody @Valid ItemDTO itemDTO) {
		Item item=this.itemService.findById(itemId);
		if(item!=null) {
			item.setName(itemDTO.getName());
			item.setQuantities(itemDTO.getQuantities());
			return this.itemService.saveItem(item);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteItem(@PathVariable("id") Long itemId) {
		this.itemService.deleteById(itemId);
		return "Success fully deleted";
	}
}
