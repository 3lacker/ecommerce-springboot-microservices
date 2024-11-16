package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service" ,r -> r.path("/api/products/**").uri("lb://product-service"))
                .route("inventory-service" ,r -> r.path("/api/inventories/**").uri("lb://inventory-service"))
                .route("customer-service" ,r -> r.path("/api/customers/**").uri("lb://customer-service"))



                .build();
    }}
