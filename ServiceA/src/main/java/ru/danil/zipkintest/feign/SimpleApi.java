package ru.danil.zipkintest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "zipkin", url = "${feign.url}", value = "zipkin")
public interface SimpleApi {

    @GetMapping
    String getName();

}
