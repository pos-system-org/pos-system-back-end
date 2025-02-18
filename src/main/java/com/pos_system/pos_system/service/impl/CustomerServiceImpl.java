package com.pos_system.pos_system.service.impl;

import com.pos_system.pos_system.dto.requestDto.RequestCustomerDto;
import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.exception.DuplicateEntryException;
import com.pos_system.pos_system.exception.NotFoundException;
import com.pos_system.pos_system.repository.CustomerRepo;
import com.pos_system.pos_system.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void create(RequestCustomerDto dto) {
        if(dto.equals(null)){
            throw new NotFoundException("Please enter customer details!");
        }
        Optional<Customer> selectedUser = customerRepo.findByEmail(dto.getEmail(), dto.getPhone());
        if (selectedUser.isPresent()) {
            throw new DuplicateEntryException("User Already Exists!");
        }
        try {
            Customer customer = new Customer();
            customer.setPropertyId(UUID.randomUUID().toString());
            customer.setName(dto.getName());
            customer.setEmail(dto.getEmail());
            customer.setAddress(dto.getAddress());
            customer.setPhone(dto.getPhone());
            customer.setAge(dto.getAge());
            customerRepo.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }
}
