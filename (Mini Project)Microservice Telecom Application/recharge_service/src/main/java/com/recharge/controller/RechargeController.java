package com.recharge.controller;

import com.recharge.entity.Plan;
import com.recharge.entity.Recharge;
import com.recharge.entity.RechargeHistory;
import com.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RechargeService rechargeService;



    @GetMapping
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @PostMapping
    public Object addRecharge(@RequestBody Recharge recharge) {
        Plan plan = restTemplate.getForObject(
                "http://PLAN-SERVICE/plan/" + recharge.getPlanId(),
                Plan.class);

        if (plan == null) {
            return "Invalid plan selected.";
        }

        if ("POSTPAID".equalsIgnoreCase(plan.getType())) {
            recharge.setRechargeDate(LocalDateTime.now());
            rechargeService.addRecharge(recharge);
            return "Recharge successful for POSTPAID plan. Bill will be generated monthly.";
        }

        if ("PREPAID".equalsIgnoreCase(plan.getType())) {
            List<Recharge> previousRecharges = rechargeService.findByCustomerId(recharge.getCustomerId());

            if (!previousRecharges.isEmpty()) {
                previousRecharges.sort((r1, r2) -> r2.getRechargeDate().compareTo(r1.getRechargeDate()));
                Recharge lastRecharge = previousRecharges.get(0);

                Plan lastPlan = restTemplate.getForObject(
                        "http://PLAN-SERVICE/plan/" + lastRecharge.getPlanId(),
                        Plan.class);

                if (lastPlan != null) {
                    LocalDateTime validUntil = lastRecharge.getRechargeDate().plusDays(lastPlan.getValidity());
                    if (LocalDateTime.now().isBefore(validUntil)) {
                        return "Cannot recharge now. Your current PREPAID plan is still valid until " + validUntil + ".";
                    }
                }
            }

            recharge.setRechargeDate(LocalDateTime.now());
            rechargeService.addRecharge(recharge);
            return "Recharge successful for PREPAID plan.";
        }

        return "Invalid plan type.";
    }


    @GetMapping("{customerId}")
    public List<RechargeHistory> getRechargesByCustomer(@PathVariable Long customerId) {
        List<Recharge> recharges = rechargeService.findByCustomerId(customerId);
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
