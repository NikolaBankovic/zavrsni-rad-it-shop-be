package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.SoftwareType;

public record SoftwareDto(
        Long id,
        String name,
        double price,
        String description,
        SoftwareType softwareType
) {
}
