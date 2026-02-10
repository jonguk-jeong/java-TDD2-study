package com.back.WiseSaying.entity;


import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WiseSaying {

    private int id;
    private String saying;
    private String author;

    // 매개 변수 2개 있는 생성자임 3개 짜리는 AllArgsConstructor가 만들어주고 있음
    public WiseSaying(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }

    public boolean isNew() {
        return id == 0;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("saying", saying);
        map.put("author", author);

        return map;
    }

    public static WiseSaying fromMap(Map<String, Object> map) {
        int id = (int) map.get("id");
        String saying = (String) map.get("saying");
        String author = (String) map.get("author");

        return new WiseSaying(id, saying, author);
    }
}