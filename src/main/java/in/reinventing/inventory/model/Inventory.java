package in.reinventing.inventory.model;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Inventory extends AuditModel{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String contact;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER,mappedBy = "inventory",orphanRemoval = true)
	private List<Category> categories=new ArrayList<>();

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", categories=" + categories + "]";
	}
}
