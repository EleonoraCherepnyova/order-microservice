package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderDTO;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDTO::new)
                .toList();
    }

    @Override
    public OrderDTO getOrderById(String id) {
        return orderRepository.findById(id)
                .map(OrderDTO::new)
                .orElseThrow(() -> new RuntimeException("order with id [%s] not found".formatted(id)));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(String userId) {
        System.out.println("Orders for userId: " + userId);
        List<Order> orders = orderRepository.findByUserId(userId);
        System.out.println("Orders found: " + orders);
        return orders.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }
}
