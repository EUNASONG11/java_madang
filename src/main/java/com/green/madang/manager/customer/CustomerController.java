package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.CustomerGetReq;
import com.green.madang.manager.customer.model.CustomerGetRes;
import com.green.madang.manager.customer.model.CustomerPostReq;
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
@RequestMapping("manager/customer")
@Tag(name = "고객",description = "고객 API")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록", description = "고객 등록 처리 API")
    public MyResponse<Integer> insCust(@RequestBody CustomerPostReq p) {
        return new MyResponse<>("고객 등록 완료", service.insCust(p));
    }

    @GetMapping
    @Operation(summary = "고객 리스트", description = "고객 정보 리스트 보기 API")
    public MyResponse<List<CustomerGetRes>> selCust(@ParameterObject @ModelAttribute CustomerGetReq p) {
        return new MyResponse<>(p.getPage() + "페이지 데이터", service.selCust(p));
    }
}
