package com.example.customerservice.web;


import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 1) Tous les customers en JSON
    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // 2) Seulement les noms en JSON
    @GetMapping("/names")
    public List<String> getCustomerNames() {
        return customerRepository.findAll()
                .stream()
                .map(Customer::getName)
                .toList();
    }
}

