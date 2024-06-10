package hr.fer.zavrsni1500.itshop.dto;

public record PasswordChangeDto(
        String oldPassword,
        String newPassword
) {
}
