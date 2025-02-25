package com.pos_system.pos_system.service;
import com.pos_system.pos_system.dto.request.RequestOrderDto;
import com.pos_system.pos_system.dto.response.ResponseOrderDto;
import com.pos_system.pos_system.dto.response.paginate.OrderPaginateDto;

public interface OrderService {
    public void create(RequestOrderDto dto);
    public ResponseOrderDto findById(String id);
    public void update(String id, RequestOrderDto dto);

    public OrderPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
