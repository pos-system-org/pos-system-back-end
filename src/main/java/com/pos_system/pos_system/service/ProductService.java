package com.pos_system.pos_system.service;
import com.pos_system.pos_system.dto.request.RequestProductDto;
import com.pos_system.pos_system.dto.response.ResponseProductDto;
import com.pos_system.pos_system.dto.response.paginate.ProductPaginateDto;

public interface ProductService {
    public void create(RequestProductDto dto);
    public ResponseProductDto getById(String id);
    public void update(String id ,RequestProductDto dto);
    public ProductPaginateDto getAll(String searchText, int page, int size);
    public void delete(String id);


}
