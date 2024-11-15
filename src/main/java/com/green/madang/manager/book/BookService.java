package com.green.madang.manager.book;

import com.green.madang.manager.book.model.BookPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int postBook (BookPostReq p) {
        return mapper.insBook(p);
    }
}
