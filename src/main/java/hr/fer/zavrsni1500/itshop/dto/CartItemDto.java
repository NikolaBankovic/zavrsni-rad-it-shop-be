package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.Product;

public record CartItemDto(
        Long id,
        Product product,
        int quantity
) {
}
