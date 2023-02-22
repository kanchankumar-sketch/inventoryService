package in.reinventing.inventory.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	@NotBlank(message="Name should not blank.")
	private String name;
	
	@Min(value = 0,message="CategoryId not valid.")
	private Long catagoryId;
	
	@Min(value = 0,message="InventoryId not valid.")
	private Long inventoryId;
	
	private Long quantities=0L;
}
