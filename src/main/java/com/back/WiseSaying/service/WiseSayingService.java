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

    public List<WiseSaying> findListDesc() {
        return wiseSayingRepository.findListDesc();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }
}
