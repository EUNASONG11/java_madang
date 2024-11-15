package com.green.madang.manager.book;

import com.green.madang.manager.book.model.BookDelReq;
import com.green.madang.manager.book.model.BookGetReq;
import com.green.madang.manager.book.model.BookGetRes;
import com.green.madang.manager.book.model.BookPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int postBook (BookPostReq p) {
        return mapper.insBook(p);
    }

    public int delBook(BookDelReq p) {
        return mapper.delBook(p);
    }

    public List<BookGetRes> getBookList (BookGetReq p) {
        // sIdx값 세팅
        int page = p.getPage();
        int size = p.getSize();
        int sIdx = (page - 1) * size;

        p.setStartIdx(sIdx);

        // p.setSIdx( (p.getPage() - 1) * p.getSize() );
        return mapper.selBookList(p);
    }
}
