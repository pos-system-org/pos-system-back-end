package com.pos_system.pos_system.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestProductDto {
    private String description;
    private double unitPrice;
    private int qty;
}
