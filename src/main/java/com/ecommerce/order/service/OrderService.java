package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderDTO;
import com.ecommerce.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDTO> getAll();

    OrderDTO getOrderById(String id);

    Order createOrder(Order order);

    void deleteOrderById(String id);

    List<OrderDTO> getOrdersByUserId(String userId);


}
