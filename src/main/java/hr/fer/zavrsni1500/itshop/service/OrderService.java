package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.exception.EmptyCartException;
import hr.fer.zavrsni1500.itshop.model.User;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByUserId(Long userId);
    OrderDto getOrderById(Long orderId);
    OrderDto createOrder(User user) throws EmptyCartException;
    OrderDto updateOrder(OrderDto orderDto);
    void deleteOrder(Long orderId);
}
