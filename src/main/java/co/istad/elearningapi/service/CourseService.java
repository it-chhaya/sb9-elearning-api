package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findList();

}
