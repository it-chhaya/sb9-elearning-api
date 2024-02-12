package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.CourseCreationDto;
import co.istad.elearningapi.dto.CourseDto;
import co.istad.elearningapi.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    List<CourseDto> findList() {
        return courseService.findList();
    }

    @GetMapping("/{id}")
    CourseDto findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    void createNew(@Valid @RequestBody CourseCreationDto courseCreationDto) {
        courseService.createNew(courseCreationDto);
    }
}
