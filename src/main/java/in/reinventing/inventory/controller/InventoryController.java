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

import in.reinventing.inventory.dto.InventoryDTO;
import in.reinventing.inventory.model.Category;
import in.reinventing.inventory.model.Inventory;
import in.reinventing.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping
	public List<Inventory> getAllInventory() {
		return this.inventoryService.getAllInvetory();
	}

	@PostMapping
	public Inventory saveInventory(@RequestBody @Valid InventoryDTO inventoryDTO) {
		Inventory inventory = Inventory.builder().address(inventoryDTO.getAddress()).contact(inventoryDTO.getContact())
				.name(inventoryDTO.getName()).build();
		return this.inventoryService.saveInventory(inventory);
	}

	@PutMapping("/{id}")
	public Inventory updateInventory(@PathVariable("id") Long id, @RequestBody @Valid InventoryDTO inventoryDTO) {
		Inventory inventory = this.inventoryService.getInventoryById(id);
		if (inventory != null) {
			inventory.setAddress(inventoryDTO.getAddress());
			inventory.setContact(inventoryDTO.getContact());
			inventory.setName(inventoryDTO.getName());
			System.out.println(inventory);
			return this.inventoryService.saveInventory(inventory);
		}
		return null;
	}
	
	@DeleteMapping("/{inventoryId}")
	public String deteleInventory(@PathVariable("inventoryId") Long inventoryId) {

		Inventory inventory = this.inventoryService.getInventoryById(inventoryId);
		if (inventory != null) {
			System.out.println(inventory);
			this.inventoryService.deleteById(inventoryId);
			return "Successfully Deleted inventory with id = " + inventoryId;
		}
		return "Not found inventory with id = " + inventoryId;
	}

}
