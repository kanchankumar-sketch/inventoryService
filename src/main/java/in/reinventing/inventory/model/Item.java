package in.reinventing.inventory.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Instant createdAt=Instant.now();
	private Instant updatedAt=Instant.now();
	
	private Long quantities=0L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
}
