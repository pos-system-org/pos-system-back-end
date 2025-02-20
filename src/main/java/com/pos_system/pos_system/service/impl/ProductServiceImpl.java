package com.pos_system.pos_system.service.impl;
import com.pos_system.pos_system.dto.request.RequestProductDto;
import com.pos_system.pos_system.dto.response.ResponseProductDto;
import com.pos_system.pos_system.dto.response.paginate.ProductPaginateDto;
import com.pos_system.pos_system.entity.Product;
import com.pos_system.pos_system.repo.ProductRepo;
import com.pos_system.pos_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public void create(RequestProductDto dto) {
        Product product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .build();
        productRepo.save(product);
    }
    @Override
    public ResponseProductDto getById(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("Product not Found!");
        }
        return toResponseProduct(selectedProduct.get());
    }
    private ResponseProductDto toResponseProduct(Product product){
        return ResponseProductDto.builder()
                .productId(product.getProductId())
                .description(product.getDescription())
                .uitPrice(product.getUnitPrice())
                .qty(product.getQty())
                .build();
    }
    @Override
    public void update(String id, RequestProductDto dto) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        Product product = selectedProduct.get();
        product.setDescription(dto.getDescription());
        product.setUnitPrice(dto.getUnitPrice());
        product.setQty(dto.getQty());

        productRepo.save(product);
    }
    @Override
    public ProductPaginateDto getAll(String searchText, int page, int size) {
        return ProductPaginateDto.builder()
                .dataList(productRepo.findAllWithSearchText(searchText,PageRequest.of(page,size)).stream().map(this::toResponseProduct).toList())
                .count(
                        productRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);

    }
}
