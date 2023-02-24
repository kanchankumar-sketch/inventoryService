package in.reinventing.inventory.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryDTO {

	@NotBlank(message="Name is modatory.")
	private String name;
	
	@NotBlank(message="Address is modatory.")
	private String address;
	
	@NotBlank(message="Contact is modatory.")
	private String contact;
}
