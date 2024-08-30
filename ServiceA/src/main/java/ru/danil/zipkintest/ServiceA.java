package ru.danil.zipkintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"ru.danil.api", "ru.danil.zipkintest"})
@EnableFeignClients
@SpringBootApplication
public class ServiceA {

    public static void main(String[] args) {
        SpringApplication.run(ServiceA.class, args);
    }

}
