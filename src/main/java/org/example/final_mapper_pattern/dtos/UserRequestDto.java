package org.example.final_mapper_pattern.dtos;

public record UserRequestDto(
        String name,
        String lastname,
        String email,
        String password
) {
}
