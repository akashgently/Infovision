package com.recharge.service;

import com.recharge.entity.Recharge;
import com.recharge.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;

    public List<Recharge> getAllRecharges(){
        return rechargeRepository.findAll();
    }

    public Recharge addRecharge(Recharge recharge){
        return rechargeRepository.save(recharge);
    }

    public List<Recharge> findByCustomerId(Long id){
        return rechargeRepository.findByCustomerId(id);
    }
}
