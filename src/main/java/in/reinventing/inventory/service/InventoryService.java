package in.reinventing.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reinventing.inventory.model.Inventory;
import in.reinventing.inventory.repository.InventoryRepository;

@Service
@Transactional
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	public List<Inventory> getAllInvetory(){
		return this.inventoryRepository.findAll();
	}
	
	public Inventory saveInventory(Inventory inventory) {
		System.out.println(inventory);
		return this.inventoryRepository.save(inventory);

	}
	
	public Inventory getInventoryById(Long id) {
		return this.inventoryRepository.findById(id).orElse(null);
	}
}
