package com.pos_system.pos_system.service;
import com.pos_system.pos_system.dto.request.RequestCustomerDto;
import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import com.pos_system.pos_system.dto.response.paginate.CustomerPaginateDto;

public interface CustomerService{
    public void create(RequestCustomerDto dto);
    public ResponseCustomerDto findById(String id);
    public void update(String id, RequestCustomerDto dto);
    public CustomerPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);

}
