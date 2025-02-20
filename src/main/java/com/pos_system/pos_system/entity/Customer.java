package com.pos_system.pos_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
