package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "exchangeClient", url = "${exchange.url}")
public interface ExchangeFeign {

    @GetMapping(path = "${exchange.request}")
    String getCurrency(@PathVariable String date);

}
