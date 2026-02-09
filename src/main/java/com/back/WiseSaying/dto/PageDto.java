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
}
