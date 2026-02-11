package com.back.WiseSaying.service;

import com.back.WiseSaying.dto.PageDto;
import com.back.WiseSaying.entity.WiseSaying;
import com.back.WiseSaying.repository.WiseSayingRepository;
import com.back.global.AppContext;

import java.util.Optional;

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

    public boolean delete(int id) {
        Optional<WiseSaying> wiseSayingOp = wiseSayingRepository.findById(id);
        if(wiseSayingOp.isEmpty()) {
            return false;
        }
        return wiseSayingRepository.delete(wiseSayingOp.get());
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }

    public PageDto findListDesc(String kw, String kwt, int page, int pageSize) {
        return switch (kwt) {
            case "content" -> wiseSayingRepository.findByContentContainingDesc(kw, page, pageSize);
            case "author" -> wiseSayingRepository.findByAuthorContainingDesc(kw, page, pageSize);
            default -> wiseSayingRepository.findAll(page, pageSize);
        };
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findById(id).orElse(null);
    }

}