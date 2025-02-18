package com.pos_system.pos_system.service.impl;

import com.pos_system.pos_system.dto.requestDto.RequestCustomerDto;
import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.exception.BadRequestException;
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

    @Override
    public void update(RequestCustomerDto dto,String id) {
        try{
            if (dto.equals(null)){
                throw new BadRequestException("Please Fill the Input");
            }
            Optional<Customer> selectedCus = customerRepo.findById(id);
            if(selectedCus.isEmpty()){
                throw new NotFoundException("User Not Found!");
            }
            Customer object = new Customer();
            object.setPropertyId(id);
            object.setName(dto.getName());
            object.setEmail(dto.getEmail());
            object.setAddress(dto.getAddress());
            object.setPhone(dto.getPhone());
            object.setAge(dto.getAge());
            customerRepo.save(object);
        }catch (Exception e){
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }
}
