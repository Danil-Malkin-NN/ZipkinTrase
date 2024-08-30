package ru.danil.zipkintest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "zipkinValue", url = "${feign.url}")
public interface SimpleApi {

    @GetMapping
    String getName();

}
