package com.ljt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayserverApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApp.class,args);
    }
}
