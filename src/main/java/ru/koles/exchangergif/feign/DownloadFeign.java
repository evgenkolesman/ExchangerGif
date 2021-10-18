package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

/**
 * Клиент для загрузки
 * наших гифок в зависимости от адреса
 *
 * @author Evgeniy Kolesnikov
 * telegram 89616927595
 * email evgeniysanich@mail.ru
 */

@FeignClient(name = "downloadClient", url = "placeholder")
public interface DownloadFeign {

    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI url);
}
