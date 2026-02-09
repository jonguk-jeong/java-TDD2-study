package com.back.WiseSaying.service;

import com.back.WiseSaying.entity.WiseSaying;
import com.back.WiseSaying.repository.WiseSayingRepository;
import com.back.global.AppContext;

import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc(String kw, String kwt) {
         return switch (kwt) {
            case "content" -> wiseSayingRepository.findByContentKeywordOrderByDesc(kw);
            case "author" -> wiseSayingRepository.findByAuthorKeywordOrderByDesc(kw);
            default -> wiseSayingRepository.findListDesc(); // 둘다 아니면 전부 주기
        };
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findByIdOrNull(id);
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}
