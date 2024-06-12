package hr.fer.zavrsni1500.itshop.dto;

public record OrderItemDto(
        Long id,
        ProductDto product,
        double price,
        int quantity

) {
}