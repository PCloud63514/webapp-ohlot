package com.example.ohlot.api;

import com.example.ohlot.service.GoodWordAddRequest;
import com.example.ohlot.service.GoodWordAddResponse;
import com.example.ohlot.service.GoodWordGetResponse;
import com.example.ohlot.service.GoodWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("good-words")
@RestController
public class GoodWordApi {
    private final GoodWordService goodWordService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public GoodWordAddResponse addGoodWord(@RequestBody GoodWordAddRequest request) {
        return goodWordService.addGoodWord(request);
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
    public void updateGoodWord(@RequestParam(name = "id") String id, @RequestParam(name = "content") String content) {

    }
}
