package ru.koles.exchangergif.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.koles.exchangergif.ExchangerGifApplication;
import ru.koles.exchangergif.service.ExchangeService;
import ru.koles.exchangergif.service.GifService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@SpringBootTest(classes = ExchangerGifApplication.class)
@AutoConfigureMockMvc
class ExchangeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void getGifAllCorrectTest() throws Exception{
    mvc.perform(get("/exchanger/gif"))
            .andExpect(status()
            .is2xxSuccessful())
            .andExpect(content().contentType("image/webp"));
    }

    @Test
    void getGifAllCorrectParamsTest() throws Exception{
        mvc.perform(get("/exchanger/gif?currency=USD")).andExpect(status()
                        .is2xxSuccessful())
                .andExpect(content().contentType("image/webp"));
    }

    @Test
    void getGifInCorrectAddressTest() throws Exception{
        mvc.perform(get("/exchanger/gif/USD"))
                .andExpect(status()
                        .is4xxClientError());
    }
}