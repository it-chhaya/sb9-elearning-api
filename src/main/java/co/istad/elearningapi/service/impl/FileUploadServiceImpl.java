package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.FileDto;
import co.istad.elearningapi.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file-upload.server-path}")
    private String serverPath;

    @Value("${file-upload.base-uri}")
    private String baseUri;

    @Override
    public FileDto uploadSingle(MultipartFile file) {

        String extension = this.extractExtension(file.getOriginalFilename());
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

    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {

        List<FileDto> fileListDto = new ArrayList<>();

        files.forEach(file -> {
            fileListDto.add(this.uploadSingle(file));
        });

        return fileListDto;
    }

    @Override
    public FileDto findByName(String name) throws IOException {
        Path path = Paths.get(serverPath + name);
        Resource res = UrlResource.from(path.toUri());
        return FileDto.builder()
                .name(res.getFilename())
                .size(res.contentLength())
                .extension(this.extractExtension(res.getFilename()))
                .uri(baseUri + res.getFilename())
                .build();
    }
    private String extractExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf(".");
        return fileName.substring(lastIndexOfDot + 1);
    }

}
