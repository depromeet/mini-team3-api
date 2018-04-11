package com.depromeet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class ImageService {
	
	public String uploadImage(byte[] data, String uploadPath, String originalFileName,
			String fileNamePrefix, String fileNameSuffix) throws IOException {
		
		Path dirPath = Paths.get(uploadPath);
        
        if (Files.notExists(dirPath)) {
        	Files.createDirectories(dirPath);
        }
        
        Path filePath = Files.createTempFile(dirPath, fileNamePrefix, fileNameSuffix);
        Files.write(filePath, data);
        
        return filePath.getFileName().toString();
	}
}
