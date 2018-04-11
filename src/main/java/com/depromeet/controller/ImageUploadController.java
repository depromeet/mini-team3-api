package com.depromeet.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.depromeet.exception.InternalServerErrorException;
import com.depromeet.exception.UnprocessableEntityException;
import com.depromeet.models.dto.ImageUploadResponse;
import com.depromeet.service.ImageService;
import com.depromeet.utils.FileUtils;

@RestController
@RequestMapping("/images")
public class ImageUploadController {
	
	public static final String BASE_DIRECTORY = System.getProperty("user.dir") + "/upload";
	public static final String UPLOAD_DIRECTORY = "/images/";
	
	@Autowired
	private ImageService imageService;
	
    @PostMapping("/upload")
	@ResponseStatus(HttpStatus.OK)
	public ImageUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
        	throw new UnprocessableEntityException("업로드할 파일을 선택해주세요.");
        }
        
        String fileName = "";
        try {
            fileName = imageService.uploadImage(file.getBytes(),
            		BASE_DIRECTORY + UPLOAD_DIRECTORY,
            		file.getOriginalFilename(),
            		"profile_",
            		"." + FileUtils.getFileExtension(file.getOriginalFilename()));
            
        } catch (IOException e) {
            throw new InternalServerErrorException("파일을 업로드하지 못했습니다.");
        }
        
        return new ImageUploadResponse(UPLOAD_DIRECTORY + fileName);
    }
    
    @GetMapping("/{fileName:.+}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> view(@PathVariable String fileName) {
    	byte[] imageData = null;
    	
    	try {
	    	Path path = Paths.get(BASE_DIRECTORY + UPLOAD_DIRECTORY + fileName);
	    	imageData = Files.readAllBytes(path);
    	} catch (IOException e) {
            throw new InternalServerErrorException("파일을 조회하지 못했습니다.");
    	}
    	
    	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
    }
}