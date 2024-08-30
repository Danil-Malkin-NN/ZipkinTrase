package ru.danila.ziplintest.configuration;

import brave.Tracer;
import brave.Tracing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.BytesMessageSender;
import zipkin2.reporter.brave.AsyncZipkinSpanHandler;
import zipkin2.reporter.okhttp3.OkHttpSender;

@Configuration
public class TracingConfiguration {

    @Value("${spring.application.name}")
    String name;

    @Bean
    BytesMessageSender sender() {
        return OkHttpSender.create("http://127.0.0.1:9411/api/v2/spans");
    }

    @Bean
    AsyncZipkinSpanHandler zipkinSpanHandler(BytesMessageSender sender) {
        return AsyncZipkinSpanHandler.create(sender);
    }

    @Bean
    public Tracing tracing(AsyncZipkinSpanHandler zipkinSpanHandler) {
        return Tracing.newBuilder()
                .localServiceName(name)
                .addSpanHandler(zipkinSpanHandler)
                .build();
    }

    @Bean
    public Tracer tracer(Tracing tracing) {
        return tracing.tracer();
    }
}