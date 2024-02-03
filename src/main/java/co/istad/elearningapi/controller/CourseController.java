package co.istad.elearningapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @GetMapping
    Map<String, String> findById() {
        return Map.of("title",
                "Spring Framework");
    }
}
