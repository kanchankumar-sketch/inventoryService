package in.reinventing.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.reinventing.inventory.dto.ImagedUploadResponseDTO;
import in.reinventing.inventory.service.FileStorageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/upload")
	public ResponseEntity<ImagedUploadResponseDTO> saveImage(@RequestParam("image") MultipartFile multipartFile){
		try {
			if(multipartFile==null) {
				throw new Exception("Please upload image.");
			}
			String fileName=this.fileStorageService.saveImage(multipartFile);
			return  new ResponseEntity<ImagedUploadResponseDTO>(ImagedUploadResponseDTO.builder().message(fileName).status(true).url("/"+fileName).build() ,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<ImagedUploadResponseDTO>(ImagedUploadResponseDTO.builder().message(e.getMessage()).status(false).build() ,HttpStatus.BAD_REQUEST);
		}		
}
}
