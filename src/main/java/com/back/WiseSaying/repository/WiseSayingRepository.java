package com.back.WiseSaying.repository;

import com.back.WiseSaying.dto.PageDto;
import com.back.WiseSaying.entity.WiseSaying;

import java.util.Optional;

// 인터페이스 ==> 모든 메서드가 추상메서드인 추상 클래스
public interface WiseSayingRepository {

    WiseSaying save(WiseSaying wiseSaying);
    Optional<WiseSaying> findById(int id);
    PageDto findAll(int page, int pageSize);
    boolean delete(WiseSaying wiseSaying1);
    PageDto findByContentContainingDesc(String kw, int page, int pageSize);
    PageDto findByAuthorContainingDesc(String kw, int page, int pageSize);

}