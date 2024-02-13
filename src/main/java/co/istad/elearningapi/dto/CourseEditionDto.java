package co.istad.elearningapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseEditionDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        String thumbnail,
        @NotNull
        Boolean isFree
) {
}
