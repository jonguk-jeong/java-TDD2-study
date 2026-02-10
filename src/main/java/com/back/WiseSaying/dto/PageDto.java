package com.back.WiseSaying.dto;

import com.back.WiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PageDto {
    private int page;   // 현재 페이지
    private int pageSize;   // 페이지당 갯수
    private int totalCount; // 전체 페이지 수
    private List<WiseSaying> content;

    // 올림 해야함
    public int getPageCount() {
        return (int)Math.ceil((double)totalCount / pageSize);
    }
}
