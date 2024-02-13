package co.istad.elearningapi.dto;

import lombok.Builder;

@Builder
public record FileDto(
        String name,
        String extension,
        Long size,
        String uri
) {
}
