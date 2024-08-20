package com.ecommerce.order;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication  {
//implements CommandLineRunner
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	/*@Autowired
	OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		orderRepository.save(new Order("123",123L, new Date()));
	}*/
}
