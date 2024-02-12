package co.istad.elearningapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseCreationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        String thumbnail,
        @NotNull
        Boolean isFree,
        @NotNull
        @Positive
        Integer categoryId,
        @NotNull
        @Positive
        Integer instructorId
) {
}
