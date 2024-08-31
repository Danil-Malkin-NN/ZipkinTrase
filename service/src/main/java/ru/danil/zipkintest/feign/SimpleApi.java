package ru.danil.zipkintest.feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@ConditionalOnProperty(name = "feign.url")
@FeignClient(value = "zipkinValue", url = "${feign.url}")
public interface SimpleApi {

    @GetMapping
    String getName();

}
