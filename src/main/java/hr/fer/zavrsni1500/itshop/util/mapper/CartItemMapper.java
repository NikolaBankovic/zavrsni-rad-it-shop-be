package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.CartItemDto;
import hr.fer.zavrsni1500.itshop.model.CartItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartItemMapper {
    CartItem cartItemDtoToCartItem(CartItemDto cartItemDto);
    CartItemDto cartItemToCartItemDto(CartItem cartItem);
    List<CartItem> cartItemDtosToCartItems(List<CartItemDto> cartItemDtos);
    List<CartItemDto> cartItemsToCartItemDtos(List<CartItem> cartItems);
}
