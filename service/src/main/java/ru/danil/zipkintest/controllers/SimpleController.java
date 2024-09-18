package ru.danil.zipkintest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danil.zipkintest.feign.SimpleApi;

import java.util.Optional;

@Slf4j
@RestController
public class SimpleController {

    private final Optional<SimpleApi> simpleApi;
    private final String name;

    public SimpleController(@Autowired(required = false) SimpleApi simpleApi,
                            @Value("${spring.application.name}") String name) {
        if (simpleApi == null) {
            log.warn("Фейн для внешнего клиента не найден");
        }
        this.simpleApi = Optional.ofNullable(simpleApi);
        this.name = name;
    }


    @GetMapping("name")
    public String getName() {
        return name + " " + simpleApi.map(SimpleApi::getName)
                .orElse("end");
    }
}
