package ru.danil.zipkintest.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danil.zipkintest.feign.SimpleApi;

@RestController
@RequestMapping("main")
public class SimpleController{

    private final SimpleApi simpleApi;
    private final String name;

    public SimpleController(@Qualifier("zipkin") SimpleApi simpleApi,
                            @Value("${spring.application.name}") String name) {
        this.simpleApi = simpleApi;
        this.name = name;
    }

    @GetMapping("get")
    public String getName() {
        return name;
    }
}
