package com.ecommerce.order.controller;

import com.ecommerce.order.client.UserClient;
import com.ecommerce.order.dto.OrderDTO;
import com.ecommerce.order.dto.UserDTO;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.exception.EntityNotFoundException;
import com.ecommerce.order.exception.OrderNotFoundException;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserClient userClient;



    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<OrderDTO> orders = orderService.getAll();
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found");
        }
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(orderService.getOrderById(id));
        } catch (OrderNotFoundException ex) {
            throw new OrderNotFoundException("No orders with id " + id + "was found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws EntityNotFoundException {
        UserDTO user = null;
        try {
            user = userClient.getUserByID(order.getUserId());
        } catch (Exception e) {
            throw new EntityNotFoundException("User with id " + order.getUserId() + " not found");  // or throw custom exception with a meaningful error message.
        }

        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            orderService.deleteOrderById(id);
            // returns a 204 No Content status code, indicating that the request was
            // successful but there is no content to return.
            return ResponseEntity.noContent().build();
        } catch (OrderNotFoundException ex) {
            throw new OrderNotFoundException("Order with id " + id + "not found");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable("userId") String userId) {
        try {
            UserDTO user = null;
            try {
                user = userClient.getUserByID(userId);
            } catch (Exception e) {
                throw new EntityNotFoundException("User with id " + userId+ " not found");  // or throw custom exception with a meaningful error message.
            }
            List<OrderDTO> orders = orderService.getOrdersByUserId(userId);
            return ResponseEntity.ok(orders);
        } catch (OrderNotFoundException | EntityNotFoundException ex) {
            throw new OrderNotFoundException("User with id " + userId + "not found");
        }
    }


}
