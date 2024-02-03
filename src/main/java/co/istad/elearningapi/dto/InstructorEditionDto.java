package co.istad.elearningapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record InstructorEditionDto(
        String familyName,
        String givenName,
        String biography
) {
}
