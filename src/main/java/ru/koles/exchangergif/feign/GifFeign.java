package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "giphyClient", url = "${giphy.url}")
public interface GifFeign {

    @GetMapping(path = "${giphy.request}")
    String getGif(@PathVariable String search);

}
