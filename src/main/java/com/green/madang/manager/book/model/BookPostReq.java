package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookPostReq {
    //@Schema 애노테이션은 Swagger용 애노테이션
    @Schema(title = "도서 이름", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bookName;
    @Schema(title = "출판사 이름")
    private String publisher;
    @Schema(title = "도서 가격")
    private int price;
}
