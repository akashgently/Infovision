package com.recharge.controller;

import com.recharge.entity.Plan;
import com.recharge.entity.Recharge;
import com.recharge.entity.RechargeHistory;
import com.recharge.repository.RechargeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RechargeRepo rechargeRepo;



    @GetMapping
    public List<Recharge> getAll() {
        return rechargeRepo.findAll();
    }

    @PostMapping
    public Recharge createRecharge(@RequestBody Recharge recharge) {
        recharge.setRechargeDate(LocalDateTime.now());
        rechargeRepo.save(recharge);
        return recharge;
    }

    @GetMapping("{customerId}")
    public List<RechargeHistory> getRechargesByCustomer(@PathVariable Long customerId) {
        List<Recharge> recharges = rechargeRepo.findByCustomerId(customerId);
        List<RechargeHistory> histories=new ArrayList<>();
        for(Recharge recharge:recharges) {
            Plan plan = restTemplate.getForObject(
                    "http://PLAN-SERVICE/plan/" +recharge.getPlanId(),
                    Plan.class);
            RechargeHistory history=new RechargeHistory(recharge,plan);
            histories.add(history);
        }
        return histories;
    }
}
