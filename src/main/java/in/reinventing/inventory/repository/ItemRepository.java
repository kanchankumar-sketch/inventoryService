package in.reinventing.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.reinventing.inventory.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
