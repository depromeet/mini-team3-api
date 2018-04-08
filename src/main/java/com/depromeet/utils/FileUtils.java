package com.depromeet.utils;

public class FileUtils {
    
    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
        	return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
        	return "";
        }
    }
}
