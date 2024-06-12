package hr.fer.zavrsni1500.itshop.dto;

public record CartItemDto(
        Long id,
        ProductDto product,
        int quantity
) {
}
