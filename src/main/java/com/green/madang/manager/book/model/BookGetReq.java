package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetReq {
    private int page; // 실제 받는 값
    private int size; // 실제 받는 값
    private int startIdx; // (page - 1) * size
}
