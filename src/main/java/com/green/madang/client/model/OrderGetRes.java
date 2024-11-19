package com.green.madang.client.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetRes {
    private int orderId;
    private int bookId;
    private int saleprice;
    private String bookName;
    private String orderDate;
}
