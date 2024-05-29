package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    List<Order> orderDtosToOrders(List<OrderDto> orderDtos);
    List<OrderDto> ordersToOrderDtos(List<Order> orders);
    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);
}
