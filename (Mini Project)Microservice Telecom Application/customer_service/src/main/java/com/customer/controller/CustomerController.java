package com.customer.controller;

import com.customer.entity.*;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CustomerService customerService;

    @PostMapping("/createUser")
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
         customerService.deleteCustomer(id);
        return ResponseEntity.ok().body("Customer deleted with id "+id);
    }
}

