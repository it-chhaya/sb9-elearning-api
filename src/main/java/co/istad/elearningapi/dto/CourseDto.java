package co.istad.elearningapi.dto;

import lombok.Builder;

@Builder
public record CourseDto(
        Long id,
        String title,
        String description,
        String thumbnail,
        Boolean isFree,
        CategoryDto category,
        InstructorDto instructor
) {
}
