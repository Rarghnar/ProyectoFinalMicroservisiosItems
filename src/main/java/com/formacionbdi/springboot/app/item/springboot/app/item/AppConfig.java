package com.formacionbdi.springboot.app.item.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  
  @Bean("clientRest")
  @LoadBalanced
  public RestTemplate registrarTemplate() {
    return new RestTemplate();
  }
}
