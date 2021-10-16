package ru.koles.exchangergif.service;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.koles.exchangergif.feign.ExchangeFeign;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeFeign exchangeFeign;

    private final GifService service;

    public ResponseEntity<byte[]> getGif(String currency) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        double todayCur = getCurrency(exchangeFeign.getCurrency(date.format(calendar.getTime())), currency);

        calendar.add(Calendar.DATE, -1);
        double yesterdayCur = getCurrency(exchangeFeign.getCurrency(date.format(calendar.getTime())), currency);

        return todayCur >= yesterdayCur ? service.getGif("rich") : service.getGif("broke");
    }

    public double getCurrency(String day, String currency) {
        JSONObject data = new JSONObject(day);
        JSONObject rates = data.getJSONObject("rates");
        return rates.getDouble(currency);
    }
}
