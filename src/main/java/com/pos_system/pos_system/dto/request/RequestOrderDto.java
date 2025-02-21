package com.pos_system.pos_system.dto.request;

import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderDto {
    private Date date;
    private float nett;
    private Customer customer;
    private List<Product> products;
}
