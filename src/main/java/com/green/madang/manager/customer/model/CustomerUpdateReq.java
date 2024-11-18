package com.green.madang.manager.customer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateReq {
    private int custId;
    private String name;
    private String address;
    private String phone;
}
