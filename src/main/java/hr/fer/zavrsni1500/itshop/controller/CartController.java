package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
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
    public CartDto viewCart() {
        return cartService.viewCart(currentUserService.getCurrentUser());
    }

    @PostMapping("/add")
    public CartDto addItemToCart(@RequestParam final Long productId, @RequestParam final int quantity) {
        return cartService.addItem(currentUserService.getCurrentUser(), productId, quantity);
    }

    @PostMapping("/remove")
    public CartDto removeItemFromCart(@RequestParam final Long productId) {
        return cartService.removeItem(currentUserService.getCurrentUser(), productId);
    }

    @PostMapping("/clear")
    public CartDto clearCart() {
        return cartService.clearCart(currentUserService.getCurrentUser());
    }
}
