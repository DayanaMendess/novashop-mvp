package com.novashop.api.service;

import com.novashop.api.dto.CustomerRequest;
import com.novashop.api.model.Customer;
import com.novashop.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer create(CustomerRequest request) {
        Customer customer = new Customer(request.getFullName(), request.getEmail(), request.getPhone());
        return customerRepository.save(customer);
    }
}
