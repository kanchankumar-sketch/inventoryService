package in.reinventing.inventory.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	public String saveImage(MultipartFile multipartFile) throws Exception {
			Path path = Paths.get("Upload");

			InputStream inputStream = multipartFile.getInputStream();
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}
			String fileName = multipartFile.getOriginalFilename();
			int i = fileName.lastIndexOf(".");
			if (i > 0) {
				String extention = fileName.substring(i + 1);
				String name = UUID.randomUUID().toString() + "." + extention;
				Path filePath = path.resolve(name);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				return name;
			}
		throw new Exception("Cannot save Image!");
	}
}
