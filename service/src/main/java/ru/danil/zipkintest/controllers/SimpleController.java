package ru.danil.zipkintest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danil.zipkintest.feign.SimpleApi;
import ru.danil.zipkintest.kafka.produser.KafkaSimpleProduser;

import java.util.Optional;

@Slf4j
@RestController
public class SimpleController {

    private final Optional<SimpleApi> simpleApi;
    private final String name;

    private final Optional<KafkaSimpleProduser> kafkaSimpleProduser;

    public SimpleController(@Autowired(required = false) SimpleApi simpleApi,
                            @Value("${spring.application.name}") String name,
                            @Autowired(required = false) KafkaSimpleProduser kafkaSimpleProduser) {
        this.kafkaSimpleProduser = Optional.ofNullable(kafkaSimpleProduser);
        if (simpleApi == null) {
            log.warn("Фейн для внешнего клиента не найден");
        }
        this.simpleApi = Optional.ofNullable(simpleApi);
        this.name = name;
    }

    @GetMapping("")
    public String getName() {
        final String endWebRequesting = name + " " + simpleApi.map(SimpleApi::getName)
                .orElse("end");

        kafkaSimpleProduser.ifPresent(KafkaSimpleProduser::sendMessage);
        return endWebRequesting;
    }
}
