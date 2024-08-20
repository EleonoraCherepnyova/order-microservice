package com.ecommerce.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Order {
    @Id
    public String id;
    public String code;
    public String userId;
    public Date date;

    public  Order(){}

    public Order(String code, String userId, Date date) {
        this.code = code;
        this.userId = userId;
        this.date = date;
    }
}
