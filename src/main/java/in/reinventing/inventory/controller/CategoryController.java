package in.reinventing.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reinventing.inventory.dto.CategoryDTO;
import in.reinventing.inventory.model.Category;
import in.reinventing.inventory.model.Inventory;
import in.reinventing.inventory.service.CategoryService;
import in.reinventing.inventory.service.InventoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> getCategories(){
		return this.categoryService.findAll();
	}
	
	@PostMapping("/{inventoryId}")
	public Inventory saveCategory(@PathVariable("inventoryId") Long inventoryId, @RequestBody Category category) {
		Inventory inventory = this.inventoryService.getInventoryById(inventoryId);
		if (inventory != null) {
			category.setInventory(inventory);
			inventory.getCategories().add(category);
			return this.inventoryService.saveInventory(inventory);
		}
		return null;
	}

	@PutMapping("/{inventoryId}/{categoryId}")
	public Category updateCategory(@PathVariable("inventoryId") Long inventoryId,
			@PathVariable("categoryId") Long categoryId, @RequestBody CategoryDTO categoryDTO) {

		Category categori = this.categoryService.getCategoryById(categoryId);
		if (categori != null) {
			categori.setName(categoryDTO.getName());
			return this.categoryService.saveCategory(categori);
		}
		return null;
	}

	@DeleteMapping("/{inventoryId}/{categoryId}")
	public String deteleCategory(@PathVariable("inventoryId") Long inventoryId,
			@PathVariable("categoryId") Long categoryId) {

		Category categori = this.categoryService.getCategoryById(categoryId);
		if (categori != null) {
			System.out.println(categori);
			this.categoryService.deleteById(categoryId);
			return "Successfully Deleted category with id = " + categoryId;
		}
		return "Not found category with id = " + categoryId;
	}
}
