package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.FileDto;
import co.istad.elearningapi.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/single")
    FileDto uploadSingle(@RequestPart MultipartFile file) throws IOException {
        return fileUploadService.uploadSingle(file);
    }
    @PostMapping("/multiple")
    void uploadMultiple(@RequestPart List<MultipartFile> files) {
        files.forEach(file -> {
            System.out.println(file.getOriginalFilename());
            try {
                System.out.println(file.getResource().getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
