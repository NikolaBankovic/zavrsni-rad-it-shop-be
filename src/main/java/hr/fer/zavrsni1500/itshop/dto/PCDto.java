package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.PCType;

public record PCDto(
        Long id,
        String name,
        double price,
        String description,
        String image,
        PCType pcType
) {
}


