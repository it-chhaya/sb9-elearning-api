package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.CourseCreationDto;
import co.istad.elearningapi.dto.CourseDto;
import co.istad.elearningapi.dto.CourseEditionDto;
import co.istad.elearningapi.mapper.CourseMapper;
import co.istad.elearningapi.model.Course;
import co.istad.elearningapi.repository.CourseRepository;
import co.istad.elearningapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> findList() {
        List<Course> courses = courseRepository.findAllByIsDeletedFalse();
        return courseMapper.toCourseListDto(courses);
    }

    @Override
    public CourseDto findById(Long id) {
        Course course = courseRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Course has not been found!"));
        return courseMapper.toCourseDto(course);
    }

    @Override
    public void createNew(CourseCreationDto courseCreationDto) {
        System.out.println("Before Map: " + courseCreationDto);
        Course course = courseMapper.fromCourseCreationDto(courseCreationDto);
        course.setIsDeleted(false);
        //System.out.println("After Map: " + course.getCategory());
        //System.out.println("After Map: " + course.getCategory().getId());
        //System.out.println("After Map: " + course.getInstructor());
        //System.out.println("After Map: " + course.getInstructor().getId());
        courseRepository.save(course);
    }

    @Override
    public void editById(Long id, CourseEditionDto courseEditionDto) {

        Course course = courseRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Course has not been found!"));

        System.out.println("BEFORE MAP: " + course.getDescription());
        courseMapper.fromCourseEditionDto(course, courseEditionDto);
        System.out.println("AFTER MAP: " + course.getDescription());

        courseRepository.save(course);
    }

    @Transactional
    @Override
    public void disableById(Long id) {

        if (!courseRepository.existsByIdAndIsDeletedFalse(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Course has not been found!");
        }

        // update isDeleted status to true
        courseRepository.updateIsDeletedById(id);
    }
}
