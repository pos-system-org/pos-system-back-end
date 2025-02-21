package com.pos_system.pos_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "orderId",nullable = false, length = 80)
    private String orderId;
    @Column(name = "date",nullable = false)
    private Date date;
    @Column(name = "nett",nullable = false)
    private float nett;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
