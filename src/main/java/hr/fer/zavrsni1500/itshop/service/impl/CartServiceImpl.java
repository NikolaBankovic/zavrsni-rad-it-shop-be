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

    public CartDto getCart(User user) {
        Cart cart = cartRepository.findByUserId(user.getId());
        if (cart == null) {
            cart = createNewCart(user);
        }
        return cartMapper.cartToCartDto(cart);
    }

    public CartDto addItem(User user, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found", productId)));

        Cart cart = cartMapper.cartDtoToCart(getCart(user));

        Optional<CartItem> existingCartItem = cart.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.save(cartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
            cart.getCartItemList().add(cartItem);
            cartRepository.save(cart);
        }

        return cartMapper.cartToCartDto(cart);
    }

    public CartDto removeItem(User user, Long productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found", productId)));

        Cart cart = cartMapper.cartDtoToCart(getCart(user));

        Optional<CartItem> cartItemOptional = cart.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findFirst();

        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            cart.getCartItemList().remove(cartItem);
            cartItemRepository.delete(cartItem);
            cartRepository.save(cart);
        }

        return cartMapper.cartToCartDto(cart);
    }

    public CartDto clearCart(User user) {
        return cartMapper.cartToCartDto(createNewCart(user));
    }

    private Cart createNewCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
