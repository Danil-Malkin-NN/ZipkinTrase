package ru.danila.ziplintest.controllers;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danila.ziplintest.feign.SimpleApi;

@RestController
public class SimpleController {

    private final SimpleApi simpleApi;
    private final String name;
    private final Tracer tracer;

    public SimpleController(SimpleApi simpleApi, @Value("${spring.application.name}") String name, Tracer tracer) {
        this.simpleApi = simpleApi;
        this.name = name;
        this.tracer = tracer;
    }


    @GetMapping("")
    public String getName() {

        tracer.currentSpan()
                .tag("serviceName", name);

        return name;
    }
}
