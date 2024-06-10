package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.Role;

public record UserDto(
        String firstName,
        String lastName,
        String username,
        String email,
        String phoneNumber,
        String address,
        Role role
) {
}
