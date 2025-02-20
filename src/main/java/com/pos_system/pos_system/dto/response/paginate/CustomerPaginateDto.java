package com.pos_system.pos_system.dto.response.paginate;
import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerPaginateDto {
    private long count;
    private List<ResponseCustomerDto> dataList;
}
