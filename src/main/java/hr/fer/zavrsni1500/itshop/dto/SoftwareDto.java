package hr.fer.zavrsni1500.itshop.dto;

public record SoftwareDto(
        Long id,
        String name,
        double price,
        String description,
        String image,
        TypeDto softwareType
) {
}
