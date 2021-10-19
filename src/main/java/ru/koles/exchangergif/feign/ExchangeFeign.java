package ru.koles.exchangergif.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Клиент для сообщения с сервисом
 * обмена валют
 * получаем ответ в зависимости от даты
 *
 * @author Evgeniy Kolesnikov
 * telegram 89616927595
 * email evgeniysanich@mail.ru
 */

@FeignClient(value = "exchangeClient", url = "${exchange.url}")
public interface ExchangeFeign {

    @GetMapping(path = "${exchange.request}")
    String getCurrency(@PathVariable String date);

}
