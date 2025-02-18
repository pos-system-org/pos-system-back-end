package com.pos_system.pos_system.service;

import com.pos_system.pos_system.dto.requestDto.RequestCustomerDto;
import org.springframework.stereotype.Service;

public interface CustomerService {
    void create(RequestCustomerDto dto) throws Exception;
}
