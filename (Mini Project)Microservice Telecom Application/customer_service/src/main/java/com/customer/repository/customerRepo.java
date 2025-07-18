package com.customer.repository;

import com.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepo extends JpaRepository<Customer,Long> {
}
