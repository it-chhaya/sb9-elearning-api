package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.CourseDto;
import co.istad.elearningapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
