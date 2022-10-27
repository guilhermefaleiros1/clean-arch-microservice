package com.devdelivery.orders.infrastructure.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.PropertySource;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@PropertySource(value = "classpath:api.yml", factory = YamlPropertySourceFactory.class)
@PropertySource(value = "classpath:infrastructure.yml", factory = YamlPropertySourceFactory.class)
public @interface BasePropertySource {
}
