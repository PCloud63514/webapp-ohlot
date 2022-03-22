package com.example.ohlot.service;

import java.util.List;

public class SpyGoodWordService implements GoodWordService {
    public GoodWordAddRequest addGoodWord_argument;

    @Override
    public GoodWordAddResponse addGoodWord(GoodWordAddRequest request) {
        addGoodWord_argument = request;
        return new GoodWordAddResponse("id", request.getContent());
    }

    @Override
    public List<GoodWordGetResponse> getGoodWords() {
        return null;
    }
}
