package in.reinventing.inventory.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Instant createdAt;
	private Instant updatedAt;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Category> categories=new ArrayList<>();
}
