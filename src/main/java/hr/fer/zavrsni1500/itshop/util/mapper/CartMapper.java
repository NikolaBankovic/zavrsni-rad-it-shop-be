package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
import hr.fer.zavrsni1500.itshop.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart cartDtoToCart(CartDto cartDto);
    CartDto cartToCartDto(Cart cart);
}
