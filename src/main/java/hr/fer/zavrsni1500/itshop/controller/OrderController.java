package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
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

    @GetMapping("/{userId}")
    public List<OrderDto> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/{userId}/{orderId}")
    public OrderDto getOrderByUserIdAndOrderId(@PathVariable Long userId, @PathVariable Long orderId) {
        return orderService.getOrderByUserIdAndOrderId(userId, orderId);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderByOrderId(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping()
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        User user = currentUserService.getCurrentUser();
        return orderService.createOrder(user, orderDto);
    }

    @PutMapping()
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
