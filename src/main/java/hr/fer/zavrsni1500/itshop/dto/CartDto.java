package hr.fer.zavrsni1500.itshop.dto;

import java.util.List;

public record CartDto(
        Long id,
        UserDto user,
        List<CartItemDto> cartItemList
) {
}
