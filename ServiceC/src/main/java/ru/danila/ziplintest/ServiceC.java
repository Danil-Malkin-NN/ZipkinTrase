package ru.danila.ziplintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceC {

    public static void main(String[] args) {
        SpringApplication.run(ServiceC.class, args);
    }

}
