package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gifClient", url = "${gif.url}")
public interface GifFeign {

    @GetMapping(path = "${gif.request}")
    String getGif(@PathVariable String search);

}
