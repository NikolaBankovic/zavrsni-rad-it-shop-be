package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.exception.EmptyCartException;
import hr.fer.zavrsni1500.itshop.model.Cart;
import hr.fer.zavrsni1500.itshop.model.Order;
import hr.fer.zavrsni1500.itshop.model.OrderItem;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.CartRepository;
import hr.fer.zavrsni1500.itshop.repository.OrderRepository;
import hr.fer.zavrsni1500.itshop.service.OrderService;
import hr.fer.zavrsni1500.itshop.util.mapper.OrderItemMapper;
import hr.fer.zavrsni1500.itshop.util.mapper.OrderMapper;
import hr.fer.zavrsni1500.itshop.util.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final UserMapper userMapper;

    public List<OrderDto> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToOrderDtos(orders);
    }

    public List<OrderDto> getOrdersByUserId(Long userId){
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orderMapper.ordersToOrderDtos(orders);
    }

    public OrderDto getOrderById(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new EntityNotFoundException(String.format("Order with ID(%d) doesn't exist.", orderId)));

        return orderMapper.orderToOrderDto(order);
    }

    public OrderDto createOrder(User user) throws EmptyCartException {
        Cart cart = cartRepository.findByUserId(user.getId())
                .orElseThrow(() -> new EmptyCartException("Cart is empty"));

        List<OrderItem> orderItems = orderItemMapper.cartItemsToOrderItems(cart.getCartItemList());
        orderItems.forEach(orderItem -> orderItem.setPrice(orderItem.getProduct().getPrice()));

        Order order = new Order();
        order.setUser(user);
        order.setOrderItemsList(orderItems);
        order.setTotalAmount();
        cartRepository.delete(cart);

        return orderMapper.orderToOrderDto(orderRepository.save(order));

    }

    public OrderDto updateOrder(OrderDto orderDto){
        Order order = orderRepository.findById(orderDto.id()).orElseThrow(() ->
                new EntityNotFoundException(String.format("Order with ID(%d) doesn't exist.", orderDto.id())));
        order.setUser(userMapper.userDtoToUser(orderDto.user()));
        order.setOrderItemsList(orderItemMapper.orderItemDtosToOrderItems(orderDto.orderItems()));
        return orderMapper.orderToOrderDto(orderRepository.save(order));
    }

    public void deleteOrder(Long orderId){
        orderRepository.deleteById(orderId);
    }
}
