package com.banking.atmapp.service;
import com.banking.atmapp.repository.CustomerRepository;
import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getUsername(), customer.getSalary(), customer.getPermitDay()))
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return new CustomerDto(customer.getUsername(), customer.getSalary(), customer.getPermitDay());
    }

    public void addCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .username(customerDto.getUsername())
                .salary(customerDto.getSalary())
                .permitDay(customerDto.getPermitDay())
                .build();

        customerRepository.save(customer);
    }
}
