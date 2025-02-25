package com.pos_system.pos_system.dto.response;
import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.entity.Product;
import lombok.*;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ResponseOrderDto {
    private String orderId;
    private Date date;
    private float nett;
    private String customer;
}
