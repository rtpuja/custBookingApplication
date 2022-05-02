package com.maersk.sample.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pooja Kumawat
 * 01/05/2022 9:58 PM
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    
    @Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }
}
