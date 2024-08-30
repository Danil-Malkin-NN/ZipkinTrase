package ru.danila.ziplintest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danila.ziplintest.feign.SimpleApi;

@RestController
public class SimpleController {

    private final SimpleApi simpleApi;
    private final String name;

    public SimpleController(SimpleApi simpleApi,
                            @Value("${spring.application.name}") String name) {
        this.simpleApi = simpleApi;
        this.name = name;
    }

    @GetMapping
    public String getName() {
        return name;
    }
}
