package com.green.madang.client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPostReq {
    @Schema(title = "고객 id", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    private int custId;
    @Schema(title = "책 id", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    private int bookId;
}
