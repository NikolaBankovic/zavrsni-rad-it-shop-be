package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.exception.EmptyCartException;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.service.CurrentUserService;
import hr.fer.zavrsni1500.itshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CurrentUserService currentUserService;

    @GetMapping("/all")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<OrderDto> getOrdersByUserId(@PathVariable final Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderByOrderId(@PathVariable final Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping()
    public OrderDto createOrder() throws EmptyCartException {
        final User user = currentUserService.getCurrentUser();
        return orderService.createOrder(user);
    }

    @PutMapping()
    public OrderDto updateOrder(@RequestBody final OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable final Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
