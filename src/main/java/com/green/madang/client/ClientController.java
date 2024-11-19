package com.green.madang.client;

import com.green.madang.client.model.OrderGetReq;
import com.green.madang.client.model.OrderGetRes;
import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("client")
@Tag(name = "주문",description = "주문 API")
public class ClientController {
    private final ClientService service;

    @PostMapping("order")
    @Operation(summary = "책 주문", description = "책 주문 처리 API")
    public MyResponse<Integer> insOrders(@RequestBody OrderPostReq p) {
        return new MyResponse<>("주문 완료", service.insOrders(p));
    }

    //본인이 주문한 책 리스트
    @GetMapping("order")
    @Operation(summary = "책 주문 리스트", description = "책 주문 리스트 처리 API")
    public MyResponse<List<OrderGetRes>> selOrders(@ParameterObject @ModelAttribute OrderGetReq p) {
        return new MyResponse<>("책 리스트", service.selOrders(p));
    }

}
