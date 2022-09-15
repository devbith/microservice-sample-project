package com.excercise.springmicroervice.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

  @Bean
  public RouteLocator gatewayRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
    return routeLocatorBuilder.routes()
        .route(p -> p.path("/get")
            .filters( f -> f
                .addRequestHeader("MyHeader", "MYUri")
                .addRequestParameter("MyParam", "ParamValue"))
            .uri("http://httpbin.org"))
        .route(p -> p.path("/currency-exchange/**") .uri("lb://currency-exchange"))
        .route(p -> p.path("/currency-conversion/**") .uri("lb://currency-conversion"))
        .route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-feign"))
        .route(p -> p.path("/currency-conversion-new/**")
            .filters(f -> f.rewritePath("/currency-conversion-new/(?<segement>.*)", "/currency-conversion-feign/${segment}"))
            .uri("lb://currency-conversion-feign"))
        .build();

  }
}
