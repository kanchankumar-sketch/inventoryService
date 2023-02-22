package in.reinventing.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImagedUploadResponseDTO {
	private Boolean status;
	private String message;
	private String url;
}
