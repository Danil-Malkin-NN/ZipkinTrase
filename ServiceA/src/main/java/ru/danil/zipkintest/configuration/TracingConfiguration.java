package ru.danil.zipkintest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {

    @Value("${spring.application.name}")
    String name;


}