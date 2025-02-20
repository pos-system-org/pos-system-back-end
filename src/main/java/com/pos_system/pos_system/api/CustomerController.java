package com.pos_system.pos_system.api;
import com.pos_system.pos_system.dto.request.RequestCustomerDto;
import com.pos_system.pos_system.service.CustomerService;
import com.pos_system.pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"customer Create!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(200,"customer data!",customerService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestCustomerDto dto){
        customerService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"customer was Updated!",null),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(201,"customer list!..",customerService.findAll(searchText,page,size)),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"customer delete!..", null ),
                HttpStatus.CREATED
        );
    }

}
