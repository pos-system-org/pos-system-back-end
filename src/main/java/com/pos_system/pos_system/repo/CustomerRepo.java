package com.pos_system.pos_system.repo;
import com.pos_system.pos_system.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>  {
    @Query(value = "SELECT * FROM customer WHERE `address` LIKE %?1% OR email LIKE %?1% OR `name` LIKE %?1% ORDER BY `name` DESC",nativeQuery = true)
    public Page<Customer> findAllWithSearchText(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM customer WHERE `address` LIKE %?1% OR email LIKE %?1% OR `name` LIKE %?1% ",nativeQuery = true)
    public long countAllWithSearchText(String searchText);

}
