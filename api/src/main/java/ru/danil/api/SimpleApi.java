package ru.danil.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "zipkin", url = "${feign.url}", value = "zipkin")
public interface SimpleApi {

    @GetMapping
    String getName();

}
