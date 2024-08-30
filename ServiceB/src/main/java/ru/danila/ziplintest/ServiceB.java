package ru.danila.ziplintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
public class ServiceB {

    public static void main(String[] args) {
        SpringApplication.run(ServiceB.class, args);
    }

}
