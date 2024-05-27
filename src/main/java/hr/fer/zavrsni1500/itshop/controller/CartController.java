package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.service.CartService;
import hr.fer.zavrsni1500.itshop.service.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CurrentUserService currentUserService;

    @GetMapping()
    public CartDto getCart() {
        User user = currentUserService.getCurrentUser();
        return cartService.getCart(user);
    }

    @PostMapping("/add")
    public CartDto addItemToCart(@RequestParam Long productId, @RequestParam int quantity) {
        User user = currentUserService.getCurrentUser();
        return cartService.addItem(user, productId, quantity);
    }

    @PostMapping("/remove")
    public CartDto removeItemFromCart(@RequestParam Long productId) {
        User user = currentUserService.getCurrentUser();
        return cartService.removeItem(user, productId);
    }

    @PostMapping("/clear")
    public CartDto clearCart() {
        User user = currentUserService.getCurrentUser();
        return cartService.clearCart(user);
    }
}
