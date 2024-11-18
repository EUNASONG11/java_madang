package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j //콘솔에 값이 나올 수 있게 해줌
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/book")
@Tag(name = "도서",description = "도서 API")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "도서 입고 처리 API")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p) {
        log.info("info"); //정보
        log.info("info ---- {} ", p);
        log.warn("warn"); //경고
        log.error("error"); //에러

        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description = "도서 정보 리스트 보기 API")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p) {
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> updBook(@RequestBody BookUpdateReq p) {
        int result = service.updBook(p);
        MyResponse<Integer> response = new MyResponse<>(p.getBookId() + "번책 수정 완료", result);
        return response;
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> delBook (@ModelAttribute BookDeleteReq p) {
        return new MyResponse<>("책 삭제 완료", service.delBook(p));
    }
}
