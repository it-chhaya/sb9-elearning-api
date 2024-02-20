package co.istad.elearningapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record VerifyDto(
        @NotBlank
        String email,
        @NotBlank
        String verifiedCode
) {
}
