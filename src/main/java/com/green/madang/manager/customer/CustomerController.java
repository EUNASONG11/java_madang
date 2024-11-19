package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
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
    //@ParameterObject - Swagger용 애노테이션, RequestParam으로 설정했을 때 나오는 FORM처럼 되게 한다.
    public MyResponse<List<CustomerGetRes>> selCust(@ParameterObject @ModelAttribute CustomerGetReq p) {
        return new MyResponse<>(p.getPage() + "페이지 데이터", service.selCust(p));
    }

    //RequestParam
    @GetMapping("/param")
    @Operation (summary = "고객 리스트2", description = "고객 정보 리스트2")
    public MyResponse<List<CustomerGetRes>> selCust(@RequestParam int page
                                                  , @RequestParam int size
                                                  , @RequestParam (name="search_type", required = false) String searchType
                                                  , @RequestParam(name="search_text", required = false) String searchText) {
        CustomerGetReq req = new CustomerGetReq();
        req.setPage(page);
        req.setSize(size);
        req.setSearchType(searchType);
        req.setSearchText(searchText);

        log.info("get-req: {}", req);
        return new MyResponse<>(req.getPage() + "페이지 데이터", service.selCust(req));
    }

    @PutMapping
    @Operation(summary = "고객 수정", description = "고객 정보 수정 API")
    public MyResponse<Integer> upCust(@RequestBody CustomerPutReq p) {
        return new MyResponse<>(p.getCustId() + "번째 고객 수정 완료", service.updCustomer(p));
    }

    @DeleteMapping
    @Operation(summary = "고객 정보 삭제", description = "고객 정보 삭제 API")
    public MyResponse<Integer> delCust(@ParameterObject @ModelAttribute CustomerDeleteReq p) {
        return new MyResponse<>(p.getCustId() + "번째 고객 정보 삭제 완료", service.delCustomer(p));
    }
}
