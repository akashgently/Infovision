package com.recharge.repository;

import com.recharge.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeRepo extends JpaRepository<Recharge,Long> {
    List<Recharge> findByCustomerId(Long customerId);
}
