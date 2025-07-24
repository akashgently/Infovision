package com.plan.service;

import com.plan.entity.Plan;
import com.plan.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public Plan addPlan(Plan plan){
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id){
        return planRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No plan found"));
    }
}
