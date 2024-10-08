package hr.fer.zavrsni1500.itshop.dto;

import java.util.Date;
import java.util.List;

public record OrderDto(
        Long id,
        UserDto user,
        List<OrderItemDto> orderItemsList,
        double totalPrice,
        String creditCardNumber,
        Date orderDate
) {
}