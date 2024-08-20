package com.ecommerce.order.dto;

import com.ecommerce.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String id;
    private String code;
    private String userId;
    private Date date;

    public OrderDTO(Order order) {
        this.id = order.id;
        this.code = order.code;
        this.userId = order.userId;
        this.date = order.date;
    }
}
