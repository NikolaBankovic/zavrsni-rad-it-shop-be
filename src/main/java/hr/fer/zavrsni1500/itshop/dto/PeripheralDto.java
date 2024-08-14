package hr.fer.zavrsni1500.itshop.dto;

public record PeripheralDto(
        Long id,
        String name,
        double price,
        String description,
        String image,
        TypeDto peripheralType
) {
}
