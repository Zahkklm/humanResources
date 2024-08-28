package com.banking.atmapp.service;

import com.banking.atmapp.repository.AdminRepository;
import com.banking.atmapp.repository.CustomerRepository;
import com.banking.atmapp.model.Admin;
import com.banking.atmapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return User.withUsername(admin.getUsername())
                    .roles("ADMIN")
                    .build();
        }

        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return User.withUsername(customer.getUsername())
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}

