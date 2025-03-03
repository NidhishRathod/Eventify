package com.example.PaymentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "UserService") // Ensure the correct Eureka service name
public interface UserClient {

    @GetMapping("/users/exists/{userId}")
    Boolean doesUserExist(@PathVariable("userId") Long userId); // ✅ Corrected return type
}
