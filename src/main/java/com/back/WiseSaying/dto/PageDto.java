package com.back.WiseSaying.dto;

import com.back.WiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PageDto {
    private int page;
    private int pageSize;
    private int totalCount;
    private List<WiseSaying> content;

    // 올림 해야함
    public int getPageCount() {
        return (int)Math.ceil((double)totalCount / pageSize);
    }
}
