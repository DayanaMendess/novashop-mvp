package com.novashop.api.controller;

import com.novashop.api.dto.CustomerRequest;
import com.novashop.api.model.Customer;
import com.novashop.api.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PostMapping
    public Customer create(@Valid @RequestBody CustomerRequest request) {
        return customerService.create(request);
    }
}
