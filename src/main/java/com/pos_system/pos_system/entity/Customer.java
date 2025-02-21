package com.pos_system.pos_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
public class Customer {
    @Id
    @Column(name = "property_id", nullable = false,length = 80)
    private String propertyId;
    @Column(name = "name",nullable = false,length = 45)
    private String name;
    @Column(name = "email",unique = true,nullable = false,length = 100)
    private String email;
    @Column(name = "phone",length = 20,nullable = false)
    private String phone;
    @Column(name = "address",length = 255,nullable = false)
    private String address;
    @Column(name = "isActive", columnDefinition = "TINYINT")
    private boolean isActive;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

}
