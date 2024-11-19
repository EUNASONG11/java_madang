package com.green.madang.manager.order;

import com.green.madang.manager.order.model.OrderGetReq;
import com.green.madang.manager.order.model.OrderGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    public List<OrderGetRes> selOrderList(OrderGetReq req) {
        int page = req.getPage();
        int size = req.getSize();
        int sIdx = (page - 1) * size;
        req.setStartIdx(sIdx);

//        req.setStartIdx((req.getPage() - 1) * req.getSize());
        return mapper.selOrdersList(req);
    }
}
