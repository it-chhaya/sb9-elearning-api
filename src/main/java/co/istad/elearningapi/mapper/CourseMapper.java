package co.istad.elearningapi.mapper;

import co.istad.elearningapi.dto.CourseDto;
import co.istad.elearningapi.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toCourseDto(Course course);
    List<CourseDto> toCourseListDto(List<Course> courses);

}
