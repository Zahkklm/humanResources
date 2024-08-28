package com.banking.atmapp.controller;

import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return adminService.getCustomerById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/customers")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        adminService.addCustomer(customerDto);
    }

}
