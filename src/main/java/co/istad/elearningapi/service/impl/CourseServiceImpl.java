package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.CourseDto;
import co.istad.elearningapi.mapper.CourseMapper;
import co.istad.elearningapi.model.Course;
import co.istad.elearningapi.repository.CourseRepository;
import co.istad.elearningapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> findList() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toCourseListDto(courses);
    }

}
