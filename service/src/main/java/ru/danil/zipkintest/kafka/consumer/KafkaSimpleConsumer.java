package ru.danil.zipkintest.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaSimpleConsumer {

    @KafkaListener(topics = {"${kafka.in}"})
    public void getMessage(String message) {

        log.info("Получили сообщение = {}", message);

    }

}
