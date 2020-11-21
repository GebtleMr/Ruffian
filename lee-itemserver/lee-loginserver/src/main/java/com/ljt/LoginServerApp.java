package com.ljt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginServerApp {

    public static void main(String[] args) {
        SpringApplication.run(LoginServerApp.class,args);
    }
}
