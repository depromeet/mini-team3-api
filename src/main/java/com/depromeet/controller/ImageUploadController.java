package com.depromeet.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.depromeet.models.dto.ImageUploadResponse;
import com.depromeet.utils.FileUtils;

@RestController
@RequestMapping("/images")
public class ImageUploadController {
	
	public static final String BASE_DIRECTORY = System.getProperty("user.dir") + "/upload";
	public static final String UPLOAD_DIRECTORY = "/images/";
	
    @PostMapping("/upload")
	@ResponseStatus(HttpStatus.OK)
    public ImageUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }
        
        Path dirPath = null;
        String fileName = "";
        try {
            byte[] bytes = file.getBytes();
            dirPath = Paths.get(BASE_DIRECTORY + UPLOAD_DIRECTORY);
            
            if (Files.notExists(dirPath)) {
            	Files.createDirectories(dirPath);
            }
            Path filePath = Files.createTempFile(dirPath, "profile_",
            		"." + FileUtils.getFileExtension(file.getOriginalFilename()));
            Files.write(filePath, bytes);
            
            fileName = filePath.getFileName().toString();

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return new ImageUploadResponse(UPLOAD_DIRECTORY + fileName);
    }
    
    @GetMapping("/{fileName:.+}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> view(@PathVariable String fileName) {
    	byte[] imageBytes = null;
    	
    	try {
	    	Path path = Paths.get(BASE_DIRECTORY + UPLOAD_DIRECTORY + fileName);
	    	imageBytes = Files.readAllBytes(path);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
}