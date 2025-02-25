package com.pos_system.pos_system.api;

import com.pos_system.pos_system.dto.request.RequestOrderDto;
import com.pos_system.pos_system.dto.response.paginate.OrderPaginateDto;
import com.pos_system.pos_system.service.OrderService;
import com.pos_system.pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestOrderDto dto){
        orderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order Create!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Order data!",orderService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestOrderDto dto){
        orderService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order was Updated!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        OrderPaginateDto all = orderService.findAll(searchText, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200,"Order list!..",all),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        orderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"Order delete!..", null ),
                HttpStatus.CREATED
        );
    }
}
