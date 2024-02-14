package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.FileDto;
import co.istad.elearningapi.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @PostMapping(value = "/single",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FileDto uploadSingle(@RequestPart MultipartFile file) {
        return fileUploadService.uploadSingle(file);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/multiple",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    List<FileDto> uploadMultiple(@RequestPart List<MultipartFile> files) {
        return fileUploadService.uploadMultiple(files);
    }

    @GetMapping("/{name}")
    FileDto findByName(@PathVariable String name) throws IOException {
        return fileUploadService.findByName(name);
    }

}
