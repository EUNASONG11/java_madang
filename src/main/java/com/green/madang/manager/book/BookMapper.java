package com.green.madang.manager.book;

import com.green.madang.manager.book.model.BookDelReq;
import com.green.madang.manager.book.model.BookGetReq;
import com.green.madang.manager.book.model.BookGetRes;
import com.green.madang.manager.book.model.BookPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int insBook(BookPostReq p);
    int delBook(BookDelReq p);
    List<BookGetRes> selBookList(BookGetReq p);
}
