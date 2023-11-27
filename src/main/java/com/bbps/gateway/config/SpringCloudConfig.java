package com.bbps.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Value("${customerApp.path}")
    private String customerAppPath;
    @Value("${customerApp.port}")
    private String customerAppPort;

//    @Value("${incoming.path}")
//    private String incomingPath;
//    @Value("${incoming.port}")
//    private String incomingPort;


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path(customerAppPath).uri(customerAppPort))
               // .route(r -> r.path(incomingPath).uri(incomingPort))
                .build();
    }

}