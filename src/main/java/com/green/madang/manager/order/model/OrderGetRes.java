package com.green.madang.manager.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetRes {
    private int orderId;
    private int salePrice;
    private int custId;
    private int bookId;
    private String name;
    private String bookName;
    private String orderDate;
}
