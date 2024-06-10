package hr.fer.zavrsni1500.itshop.dto;

public record LoginResponse(
        UserDto user,
        String token
) {
}
