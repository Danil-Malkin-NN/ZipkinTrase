package ru.danila.ziplintest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "zipkinValue", url = "${feign.url}")
public interface SimpleApi {

    @GetMapping
    String getName();

}
