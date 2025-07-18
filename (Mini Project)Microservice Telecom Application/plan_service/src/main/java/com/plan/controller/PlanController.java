package com.plan.controller;

import com.plan.entity.Plan;
import com.plan.repository.planRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    planRepository planRepo;


    @GetMapping
    public List<Plan> getAll() {
        return planRepo.findAll();
    }

    @GetMapping("/{id}")
    public Plan getById(@PathVariable Long id) {
            return planRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No plan found"));
    }

    @PostMapping
    public Plan create(@RequestBody Plan plan) {
        planRepo.save(plan);
        return plan;
    }
}

