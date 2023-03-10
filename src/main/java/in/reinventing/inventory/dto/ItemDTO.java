package in.reinventing.inventory.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDTO {
	
	@NotBlank(message="Name should not blank.")
	private String name;
	private Long quantities=0L;
}
