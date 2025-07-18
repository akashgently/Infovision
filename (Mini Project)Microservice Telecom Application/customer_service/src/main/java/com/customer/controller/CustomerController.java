package com.customer.controller;

import com.customer.entity.*;
import com.customer.repository.customerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    customerRepo customerRepo;

    @PostMapping("/createUser")
    public Customer createCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Recharge>> getById(@PathVariable Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No user found"));

        List<Recharge> recharges = restTemplate.getForObject(
                "http://RECHARGE-SERVICE/recharge/" + id,
                List.class
        );
        List<CustomerDetails> customerDetailsList = new ArrayList<>();
        return ResponseEntity.status(200).body(recharges);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer updated) {
        for (Customer c : customerRepo.findAll()) {
            if (c.getId().equals(id)) {
                c.setName(updated.getName());
                c.setMobile(updated.getMobile());
                c.setEmail(updated.getEmail());
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
         customerRepo.deleteById(id);
        return ResponseEntity.ok().body("Customer deleted with id "+id);
    }
}

