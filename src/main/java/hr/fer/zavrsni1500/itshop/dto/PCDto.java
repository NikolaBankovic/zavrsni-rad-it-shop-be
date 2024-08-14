package hr.fer.zavrsni1500.itshop.dto;

public record PCDto(
        Long id,
        String name,
        double price,
        String description,
        String image,
        TypeDto pcType
) {
}


