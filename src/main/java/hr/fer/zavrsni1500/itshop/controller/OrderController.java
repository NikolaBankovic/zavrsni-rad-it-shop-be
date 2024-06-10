package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.OrderDto;
import hr.fer.zavrsni1500.itshop.exception.EmptyCartException;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.service.CurrentUserService;
import hr.fer.zavrsni1500.itshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
public class OrderController {

    private final OrderService orderService;
    private final CurrentUserService currentUserService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<OrderDto> getOrdersByUserId(@PathVariable final Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<OrderDto> getOrdersForCurrentUser() {
        final User user = currentUserService.getCurrentUser();
        return orderService.getOrdersByUserId(user.getId());
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public OrderDto updateOrder(@RequestBody final OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable final Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
