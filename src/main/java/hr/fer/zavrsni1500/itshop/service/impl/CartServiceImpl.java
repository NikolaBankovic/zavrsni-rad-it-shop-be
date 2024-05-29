package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
import hr.fer.zavrsni1500.itshop.model.Cart;
import hr.fer.zavrsni1500.itshop.model.CartItem;
import hr.fer.zavrsni1500.itshop.model.Product;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.CartItemRepository;
import hr.fer.zavrsni1500.itshop.repository.CartRepository;
import hr.fer.zavrsni1500.itshop.repository.ProductRepository;
import hr.fer.zavrsni1500.itshop.service.CartService;
import hr.fer.zavrsni1500.itshop.util.mapper.CartMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    public CartDto viewCart(User user) {
        Optional<Cart> cartOptional = cartRepository.findByUserId(user.getId());
        if (cartOptional.isPresent()) {
            return cartMapper.cartToCartDto(cartOptional.get());
        }
        Cart cart = createNewCart(user);
        return cartMapper.cartToCartDto(cart);
    }

    public CartDto addItem(User user, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found", productId)));

        Cart cart  = getCart(user);

        Optional<CartItem> cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);

        if (cartItem.isPresent()) {
            cartItem.get().setQuantity(cartItem.get().getQuantity() + quantity);
            cartItemRepository.save(cartItem.get());
        } else {
            CartItem newCartItem = new CartItem(cart, product, quantity);
            cart.getCartItemList().add(newCartItem);
            cartRepository.save(cart);
        }

        return cartMapper.cartToCartDto(cart);
    }

    public CartDto removeItem(User user, Long productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found", productId)));

        Cart cart = getCart(user);

        Optional<CartItem> cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);

        if (cartItem.isPresent()) {
            cart.getCartItemList().remove(cartItem.get());
            cartRepository.save(cart);
        }

        return cartMapper.cartToCartDto(cart);
    }

    public CartDto clearCart(User user) {
        Cart cart = getCart(user);
        cart.getCartItemList().clear();
        return cartMapper.cartToCartDto(cartRepository.save(cart));
    }

    private Cart getCart(User user) {
        Optional<Cart> cartOptional = cartRepository.findByUserId(user.getId());
        return cartOptional.orElseGet(() -> createNewCart(user));
    }

    private Cart createNewCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
