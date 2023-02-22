package in.reinventing.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.reinventing.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
