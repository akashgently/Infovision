package com.plan.controller;

import com.plan.entity.Plan;
import com.plan.repository.PlanRepository;
import com.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    PlanService planService;


    @GetMapping
    public List<Plan> getAll() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PostMapping
    public Plan addPlan(@RequestBody Plan plan) {
        planService.addPlan(plan);
        return plan;
    }
}

