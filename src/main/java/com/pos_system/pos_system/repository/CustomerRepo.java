package com.pos_system.pos_system.repository;

import com.pos_system.pos_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT * FROM customer WHERE email=?1 || phone=?2",nativeQuery = true)
    Optional<Customer> findByEmail(String email,String phone);
}
