package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.Product;

public record OrderItemDto(
        Long id,
        Product product,
        double price,
        int quantity

) {
}