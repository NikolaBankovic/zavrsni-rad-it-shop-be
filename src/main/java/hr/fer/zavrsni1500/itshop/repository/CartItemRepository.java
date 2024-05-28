package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
}
