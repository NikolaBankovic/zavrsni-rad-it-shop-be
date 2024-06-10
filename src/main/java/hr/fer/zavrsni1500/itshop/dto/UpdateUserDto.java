package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.Role;

public record UpdateUserDto(
        String username,
        String email,
        String password,
        String phoneNumber,
        String address,
        Role role
) {
}
