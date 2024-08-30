package ru.danila.ziplintest.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import ru.danil.api.SimpleApi;

@RestController
public class SimpleController implements SimpleApi {

    private final SimpleApi simpleApi;
    private final String name;

    public SimpleController(@Qualifier("zipkin") SimpleApi simpleApi,
                            @Value("${spring.application.name}") String name) {
        this.simpleApi = simpleApi;
        this.name = name;
    }

    public String getName() {
        return name + simpleApi.getName();
    }
}
