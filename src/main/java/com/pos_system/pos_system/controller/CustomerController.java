package com.pos_system.pos_system.controller;

import com.pos_system.pos_system.dto.requestDto.RequestCustomerDto;
import com.pos_system.pos_system.service.CustomerService;
import com.pos_system.pos_system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")

@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<StandardResponse> create(@Validated @RequestBody RequestCustomerDto dto) throws Exception {
        customerService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new StandardResponse("Customer Saved", 201, null));
    }

}
