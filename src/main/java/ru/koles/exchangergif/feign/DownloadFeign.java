package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "downloadClient", url = "placeholder")
public interface DownloadFeign {

    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI url);
}
