package com.pos_system.pos_system.repo;

import com.pos_system.pos_system.entity.Customer;
import com.pos_system.pos_system.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,String> {
    @Query(value = "SELECT * FROM order WHERE date LIKE %?1% OR nett LIKE %?1% OR customer LIKE %?1% OR products LIKE %?1% ",nativeQuery = true)
    public Page<Order> findAllWithSearchText(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM order WHERE date LIKE %?1% OR nett LIKE %?1% OR customer LIKE %?1% OR products LIKE %?1% ",nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}
