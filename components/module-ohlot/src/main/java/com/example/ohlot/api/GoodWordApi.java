package com.example.ohlot.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("good-words")
@RestController
public class GoodWordApi {
    // 동기화를 위해 시간 반환하기
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void addGoodWord() {

    }

    @PatchMapping
    public void updateGoodWord() {

    }

    @GetMapping
    public void getGoodWords() {

    }
}
