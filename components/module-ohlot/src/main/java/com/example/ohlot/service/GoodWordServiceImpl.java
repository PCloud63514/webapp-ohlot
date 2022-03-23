package com.example.ohlot.service;

import com.example.ohlot.domain.GoodWord;
import com.example.ohlot.domain.GoodWordRepository;
import com.example.ohlot.provider.UUIDProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GoodWordServiceImpl implements GoodWordService {
    private final UUIDProvider uuidProvider;
    private final GoodWordRepository goodWordRepository;

    @Override
    public GoodWordAddResponse addGoodWord(GoodWordAddRequest request) {
        UUID uuid = uuidProvider.randomUUID();
        if (goodWordRepository.existsById(uuid)) {
            throw new RuntimeException();
        }

        GoodWord goodWord = GoodWord.create(uuid, request.getContent());
        goodWordRepository.save(goodWord);

        return new GoodWordAddResponse(uuid.toString(), request.getContent());
    }

    @Override
    public List<GoodWordGetResponse> getGoodWords() {
        List<GoodWordGetResponse> responses = new ArrayList<>();
        List<GoodWord> goodWords = goodWordRepository.findAll();

        for (GoodWord goodWord : goodWords) {
            responses.add(new GoodWordGetResponse(goodWord.getId().toString(),
                    goodWord.getContent(),
                    goodWord.getCreateAt(),
                    goodWord.getUpdateAt()));
        }

        return responses;
    }
}
