package com.ecommerce.order.client;

import com.ecommerce.order.dto.UserDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserClient {

    @GetMapping("/api/user/{id}" )
    @Headers("CONTENT-TYPE: application/json")
    UserDTO getUserByID(@PathVariable("id") String id);
}
