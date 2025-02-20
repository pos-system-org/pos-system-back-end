package com.pos_system.pos_system.dto.response.paginate;

import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import com.pos_system.pos_system.dto.response.ResponseProductDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductPaginateDto {
    private long count;
    private List<ResponseProductDto> dataList;
}
