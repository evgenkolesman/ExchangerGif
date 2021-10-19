package ru.koles.exchangergif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Наш основной класс
 *
 * @author Evgeniy Kolesnikov
 * telegram 89616927595
 * email evgeniysanich@mail.ru
 */
@SpringBootApplication
@EnableFeignClients
public class ExchangerGifApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangerGifApplication.class, args);
    }

}
