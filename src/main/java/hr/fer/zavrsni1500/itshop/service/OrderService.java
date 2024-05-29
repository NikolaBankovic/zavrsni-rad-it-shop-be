package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.model.User;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByUserId(Long userId);
    OrderDto getOrderByUserIdAndOrderId(Long userId, Long orderId);
    OrderDto getOrderById(Long orderId);
    OrderDto createOrder(User user, OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto);
    void deleteOrder(Long orderId);
}
