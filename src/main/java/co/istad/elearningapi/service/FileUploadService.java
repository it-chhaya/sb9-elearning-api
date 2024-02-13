package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.FileDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    FileDto uploadSingle(MultipartFile file);

}
