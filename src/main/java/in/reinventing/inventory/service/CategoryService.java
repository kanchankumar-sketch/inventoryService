package in.reinventing.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reinventing.inventory.model.Category;
import in.reinventing.inventory.model.Item;
import in.reinventing.inventory.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category getCategoryById(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}

	public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
}
