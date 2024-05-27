package hr.fer.zavrsni1500.itshop.dto;

import hr.fer.zavrsni1500.itshop.model.CartItem;
import hr.fer.zavrsni1500.itshop.model.User;

import java.util.List;

public record CartDto(
        Long id,
        User user,
        List<CartItem> cartItemList
) {
}
