package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPostReq {
    private String bookName;
    private String publisher;
    private int price;
}
