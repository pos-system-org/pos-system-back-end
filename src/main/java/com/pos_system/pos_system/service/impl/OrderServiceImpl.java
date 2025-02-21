package com.pos_system.pos_system.service.impl;

import com.pos_system.pos_system.dto.request.RequestOrderDto;
import com.pos_system.pos_system.dto.response.ResponseOrderDto;
import com.pos_system.pos_system.dto.response.paginate.OrderPaginateDto;
import com.pos_system.pos_system.entity.Order;
import com.pos_system.pos_system.repo.OrderRepo;
import com.pos_system.pos_system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public void create(RequestOrderDto dto) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .date(dto.getDate())
                .nett(dto.getNett())
                .customer(dto.getCustomer())
                .products(dto.getProducts())
                .build();
        orderRepo.save(order);
    }

    @Override
    public ResponseOrderDto findById(String id) {
        Optional<Order> selectedOrder = orderRepo.findById(id);
        if (selectedOrder.isEmpty()){
            throw new RuntimeException("Order Not Found");
        }
        return toResponseOrder(selectedOrder.get());
    }

    @Override
    public void update(String id, RequestOrderDto dto) {
        Optional<Order> selectedOrder = orderRepo.findById(id);
        if (selectedOrder.isEmpty()){
            throw new RuntimeException("Order Not Found");
        }
        Order order = selectedOrder.get();
        order.setDate(dto.getDate());
        order.setNett(dto.getNett());
        order.setCustomer(dto.getCustomer());
        order.setProducts(dto.getProducts());
        orderRepo.save(order);
    }

    @Override
    public void update(String id, ResponseOrderDto dto) {

    }


    @Override
    public OrderPaginateDto findAll(String searchText, int page, int size) {
        return OrderPaginateDto.builder()
                .dataList(orderRepo.findAllWithSearchText(searchText, PageRequest.of(page, size)).stream().map(this::toResponseOrder).toList())
                .count(
                        orderRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {
        orderRepo.deleteById(id);
    }

    private ResponseOrderDto toResponseOrder(Order order){
        return ResponseOrderDto.builder()
                .orderId(order.getOrderId())
                .date(order.getDate())
                .nett(order.getNett())
                .customer(order.getCustomer())
                .products(order.getProducts())
                .build();
    }
}
