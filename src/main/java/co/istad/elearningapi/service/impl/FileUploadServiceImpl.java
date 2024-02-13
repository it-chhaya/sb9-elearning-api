package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.FileDto;
import co.istad.elearningapi.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file-upload.server-path}")
    private String serverPath;

    @Value("${file-upload.base-uri}")
    private String baseUri;

    @Override
    public FileDto uploadSingle(MultipartFile file) {

        // extract file extension
        // get last index of .
        int lastIndexOfDot = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(lastIndexOfDot + 1);
        // Create new unique file name
        String newFileName = UUID.randomUUID() + "." + extension;

        /*System.out.println(file.getOriginalFilename());
        System.out.println(newFileName);
        System.out.println(file.getContentType());
        System.out.println(extension);*/

        String absolutePath = serverPath + newFileName;
        Path path = Paths.get(absolutePath);
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return FileDto.builder()
                .name(newFileName)
                .extension(extension)
                .size(file.getSize())
                .uri(baseUri + newFileName)
                .build();
    }
}
