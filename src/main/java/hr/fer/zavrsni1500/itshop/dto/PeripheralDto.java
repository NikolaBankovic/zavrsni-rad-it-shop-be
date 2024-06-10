package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.PeripheralType;

public record PeripheralDto(
        Long id,
        String name,
        double price,
        String description,
        String image,
        PeripheralType peripheralType
) {
}
