package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerPostReq {
    @Schema(title = "고객 이름", example = "홍길동", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(title = "고객 주소", example = "대구시 달서구", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(title = "고객 번호", example = "000-0000-0000", description = "###-####-####", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
}