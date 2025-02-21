package com.pos_system.pos_system.dto.response.paginate;

import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import com.pos_system.pos_system.dto.response.ResponseOrderDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderPaginateDto {
    private long count;
    private List<ResponseOrderDto> dataList;
}
