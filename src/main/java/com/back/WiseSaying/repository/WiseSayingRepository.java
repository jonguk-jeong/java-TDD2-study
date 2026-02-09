package com.back.WiseSaying.repository;

import com.back.WiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findByContentKeywordOrderByDesc(String kw) {
        return wiseSayings.stream()
                .filter(w -> w.getSaying().contains(kw))
                .toList()
                .reversed();
    }

    public List<WiseSaying> findByAuthorKeywordOrderByDesc(String kw) {
        return wiseSayings.stream()
                .filter(w -> w.getAuthor().contains(kw))
                .toList()
                .reversed();
    }
}
