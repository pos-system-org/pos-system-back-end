package com.pos_system.pos_system.service.impl;
import com.pos_system.pos_system.dto.request.RequestCustomerDto;
import com.pos_system.pos_system.dto.response.ResponseCustomerDto;
import com.pos_system.pos_system.dto.response.paginate.CustomerPaginateDto;
import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.repo.CustomerRepo;
import com.pos_system.pos_system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    @Override
    public void create(RequestCustomerDto dto) {
        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .isActive(dto.isActive())
                .build();
        customerRepo.save(customer);
    }

    @Override
    public ResponseCustomerDto findById(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("Customer Not Found");
        }
        return toResponseCustomer(selectedCustomer.get());
    }

    @Override
    public void update(String id, RequestCustomerDto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("Customer Not Found");
        }
        Customer customer = selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setActive(dto.isActive());
        customerRepo.save(customer);
    }

    @Override
    public CustomerPaginateDto findAll(String searchText, int page, int size) {
        return CustomerPaginateDto.builder()
                .dataList(customerRepo.findAllWithSearchText(searchText, PageRequest.of(page, size)).stream().map(this::toResponseCustomer).toList())
                .count(
                        customerRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {
          customerRepo.deleteById(id);
    }

    private ResponseCustomerDto toResponseCustomer(Customer customer){
        return ResponseCustomerDto.builder()
                .propertyId(customer.getPropertyId())
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .isActive(customer.isActive())
                .build();
    }
}
