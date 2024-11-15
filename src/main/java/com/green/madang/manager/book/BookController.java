package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.BookDelReq;
import com.green.madang.manager.book.model.BookGetReq;
import com.green.madang.manager.book.model.BookGetRes;
import com.green.madang.manager.book.model.BookPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("manager/book")
public class BookController {
    private final BookService service;

    @PostMapping
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p) {
        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    public MyResponse<List<BookGetRes>> getBookList(@ModelAttribute BookGetReq p) {
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @DeleteMapping
    public int delBook(@ModelAttribute BookDelReq p) {
        return service.delBook(p);
    }
}
