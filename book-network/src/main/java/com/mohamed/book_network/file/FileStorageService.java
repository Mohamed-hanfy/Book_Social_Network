package com.mohamed.book_network.file;

import com.mohamed.book_network.book.Book;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
@RequiredArgsConstructor

public class FileStorageService {

    @Value("${spring.application.file.upload.photos-output-path}")
    private String fileUploadPath;
    public String saveFile(@NonNull MultipartFile file,@NonNull Integer userId) {
        final String fileUploadSubPath = "users" + File.separator + userId;

        return uploadFile(file, fileUploadSubPath); 
    }

    private String uploadFile(@NonNull MultipartFile file,@NonNull String fileUploadSubPath) {
        final String finalFileUploadPath = fileUploadPath + File.separator+fileUploadSubPath;
        File targetFolder = new File(finalFileUploadPath);
        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Could not create folder " + targetFolder.getAbsolutePath());
                return null;
            }
        }

        final String fileExtension = getFileExtension(file.getOriginalFilename());
        // ./uploads/users/1/454.jpg
        String targetFilePath = finalFileUploadPath + File.separator + System.currentTimeMillis() +"." +fileExtension;
        Path targetPath = Paths.get(targetFilePath);
        try{
            Files.write(targetPath,file.getBytes());
            log.info("File saved to " + targetFilePath);
            return targetFilePath;
        }catch (IOException e){
            log.error("Faild to save file to " + targetFilePath,e);
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        if(fileName == null || fileName.isEmpty()) {
            return "";
        }
        int index = fileName.lastIndexOf(".");
        if(index == -1) {return "";}

        return fileName.substring(index+1).toLowerCase();
    }
}
