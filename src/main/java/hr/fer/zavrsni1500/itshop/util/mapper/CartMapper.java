package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.CartDto;
import hr.fer.zavrsni1500.itshop.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class, UserMapper.class})
public interface CartMapper {
    Cart cartDtoToCart(CartDto cartDto);
    CartDto cartToCartDto(Cart cart);
}
