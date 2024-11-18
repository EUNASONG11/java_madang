package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int insCust(CustomerPostReq p){
        return mapper.insCustomer(p);
    }

    public List<CustomerGetRes> selCust(CustomerGetReq p) {
        int page = p.getPage();
        int size = p.getSize();
        int startIdx = (page - 1) * size;

        p.setStartIdx(startIdx);

        return mapper.selCustomerList(p);
    }

    public int updCustomer(CustomerPutReq p) {
        return mapper.updCustomer(p);
    }

    public int delCustomer(CustomerDeleteReq p) {
        return mapper.delCustomer(p);
    }
}
