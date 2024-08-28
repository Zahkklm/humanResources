package com.banking.atmapp.service;

import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getUsername(), customer.getSalary(), customer.getPermitDay()))
                .collect(Collectors.toList());
    }
}
