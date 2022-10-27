package com.devdelivery.orders.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.devdelivery.orders.infrastructure")
@EnableTransactionManagement
@EntityScan("com.devdelivery.orders.infrastructure")
@EnableCaching
public class ConfigJpaRepository {
}
