package com.pos_system.pos_system.api;
import com.pos_system.pos_system.dto.request.RequestProductDto;
import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import com.pos_system.pos_system.dto.response.ResponseProductDto;
import com.pos_system.pos_system.service.ProductService;
import com.pos_system.pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto){
        productService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Product Saved!!",null),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Product data!",productService.getById(id)),
                HttpStatus.OK
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,@RequestBody RequestProductDto dto){
        productService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product Updated!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(@RequestParam String searchText,@RequestParam int page,@RequestParam int size){
        return new ResponseEntity<>(
                new StandardResponse(201,"Product list!..",productService.getAll(searchText,page,size)),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product delete!..", null ),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/productGet")
    public ResponseEntity<StandardResponse> productGetAll(){
        List<ResponseProductDto> list = productService.productGetAll();
        return new ResponseEntity<>(new StandardResponse(200, "product list",list),
                HttpStatus.OK
        );
    }
}
