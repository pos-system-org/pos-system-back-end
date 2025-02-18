package com.pos_system.pos_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Builder
@Entity(name = "customer")
public class Customer {
    @Id
    private String propertyId;
    @Column(name = "name",nullable = false,length = 40)
    private String name;
    @Column(name = "email",nullable = false,length = 225,unique = true)
    private String email;
    @Column(name = "address",nullable = false,length = 225)
    private String address;
    @Column(name = "phone",nullable = false,unique = true,length = 10)
    private String phone;
    @Column(name = "age",nullable = false)
    private int age;

    public Customer(String propertyId, String name, String email, String address, String phone, int age) {
        this.propertyId = propertyId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public Customer() {
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
