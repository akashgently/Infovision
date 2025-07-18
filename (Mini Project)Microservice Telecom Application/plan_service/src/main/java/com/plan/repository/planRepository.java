package com.plan.repository;

import com.plan.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface planRepository extends JpaRepository<Plan,Long>
{

}
