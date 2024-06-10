package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
