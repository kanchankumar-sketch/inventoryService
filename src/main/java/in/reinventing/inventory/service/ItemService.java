package in.reinventing.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.reinventing.inventory.model.Item;
import in.reinventing.inventory.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item saveItem(Item item) {
		return this.itemRepository.save(item);
	}
	
	public Item getItemById(Long id) {
		return this.itemRepository.findById(id).orElse(null);
	}

	public void deleteById(Long itemId) {
		this.itemRepository.deleteById(itemId);
	}

	public List<Item> findAll() {
		return this.itemRepository.findAll();
	}

	public Item findById(Long itemId) {
		return this.itemRepository.findById(itemId).orElse(null);
	}
}
