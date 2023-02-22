package in.reinventing.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemStatus {
	private Boolean inStock;
	private Long items;
	private String message;
}
