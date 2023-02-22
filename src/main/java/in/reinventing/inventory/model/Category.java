package in.reinventing.inventory.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Instant createdAt;
	private Instant updatedAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;
}
