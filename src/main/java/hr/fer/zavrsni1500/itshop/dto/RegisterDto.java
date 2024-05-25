package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.Role;

public record RegisterDto(
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        String phoneNumber,
        String address,
        Role role
) {
}
