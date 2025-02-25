package com.pos_system.pos_system.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ResponseProductDto {
    private String productId;
    private String description;
    private double unitPrice;
    private int qty;
}
