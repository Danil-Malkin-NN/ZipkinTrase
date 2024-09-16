package ru.danil.zipkintest.kafka.produser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaSimpleProduser {

    @Value("${spring.application.name}")
    private String name;
    @Autowired
    private KafkaTemplate<String, String> stringStringKafkaTemplate;
    @Value("${kafka.out}")
    private String kafkaOutTopick;

    public void sendMessage() {

        final String message = String.format("""
                                             Стартовое сообщение от сервиса %s
                                             """, name);
        stringStringKafkaTemplate.send(kafkaOutTopick, message);

    }

}
