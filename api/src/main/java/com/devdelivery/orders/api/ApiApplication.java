package com.devdelivery.orders.api;

import com.devdelivery.orders.infrastructure.config.BasePropertySource;
import com.devdelivery.orders.infrastructure.config.ConfigJpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.devdelivery.orders")
@Import(ConfigJpaRepository.class)
@BasePropertySource
@EnableFeignClients(basePackages = "com.devdelivery.orders.infrastructure")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication .class, args);
    }
}