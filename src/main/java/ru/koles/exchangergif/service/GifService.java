package ru.koles.exchangergif.service;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.koles.exchangergif.feign.DownloadFeign;
import ru.koles.exchangergif.feign.GifFeign;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class GifService {

    private final GifFeign gifFeign;

    private final DownloadFeign downloadFeign;

    public ResponseEntity<byte[]> getGif(String value){
        String gif = gifFeign.getGif(value);
        return downloadFeign.getGifByUrl(getRandomGif(gif));
    }

    public URI getRandomGif(String gif){
        JSONObject data = new JSONObject(gif);
        JSONArray gifJson= data.getJSONArray("data");
        return URI.create(gifJson.getJSONObject((int)(Math.random()*(gifJson.length()))).getJSONObject("images")
                .getJSONObject("original").getString("webp"));
    }
}
