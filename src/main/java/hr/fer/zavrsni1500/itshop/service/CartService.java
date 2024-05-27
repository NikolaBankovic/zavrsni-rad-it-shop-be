package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
import hr.fer.zavrsni1500.itshop.model.User;

public interface CartService {

    CartDto getCart(User user);
    CartDto addItem(User user, Long productId, int quantity);
    CartDto removeItem(User user, Long productId);
    CartDto clearCart(User user);
}
