package com.banking.atmapp.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import com.banking.atmapp.payload.CustomerDto;
import com.banking.atmapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/view")
    public String getCustomers(Model model) {
        List<CustomerDto> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

}
