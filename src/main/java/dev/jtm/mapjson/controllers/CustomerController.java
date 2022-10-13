package dev.jtm.mapjson.controllers;

import dev.jtm.mapjson.entities.customers;
import dev.jtm.mapjson.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/json")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/saveCustomer")
    public customers saveCustomer() throws IOException {
        return customerService.saveCustomer();
    }
}
