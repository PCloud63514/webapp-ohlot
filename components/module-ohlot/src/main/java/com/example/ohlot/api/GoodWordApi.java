package com.example.ohlot.api;

import com.example.ohlot.service.GoodWordAddRequest;
import com.example.ohlot.service.GoodWordAddResponse;
import com.example.ohlot.service.GoodWordGetResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("good-words")
@RestController
public class GoodWordApi {
    // 동기화를 위해 시간 반환하기
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public GoodWordAddResponse addGoodWord(@RequestBody GoodWordAddRequest request) {
        return new GoodWordAddResponse("id", request.getContent());
    }

    @GetMapping
    public List<GoodWordGetResponse> getGoodWords() {
        ArrayList<GoodWordGetResponse> response = new ArrayList<>();

        response.add(new GoodWordGetResponse("id", "content",
                LocalDateTime.of(2022, 2, 2, 22, 22, 22),
                LocalDateTime.of(2022, 2, 2, 22, 22, 22)));

        return response;
    }

    @PatchMapping
    public void updateGoodWord() {

    }
}
