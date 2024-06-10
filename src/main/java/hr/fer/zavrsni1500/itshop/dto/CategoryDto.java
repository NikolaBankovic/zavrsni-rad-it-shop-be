package hr.fer.zavrsni1500.itshop.dto;

import java.util.List;

public record CategoryDto(
        String name,
        List<String> subCategories
) {
}
