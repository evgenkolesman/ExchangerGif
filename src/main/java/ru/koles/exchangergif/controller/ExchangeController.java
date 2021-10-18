package ru.koles.exchangergif.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.koles.exchangergif.service.ExchangeService;

/**
 * Наш основной контроллер
 * делает Get запрос
 *
 * @author Evgeniy Kolesnikov
 * telegram 89616927595
 * email evgeniysanich@mail.ru
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchanger")
public class ExchangeController {

    private final ExchangeService service;

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGif(@RequestParam(defaultValue = "USD") String currency){
        return service.getGif(currency);
    }
}
