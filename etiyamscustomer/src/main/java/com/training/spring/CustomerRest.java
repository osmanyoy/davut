package com.training.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRest {

    @Autowired
    private CustomerManager cm;

    @PostMapping("/customer/add")
    public String saveCustomer(@RequestBody final Customer customerParam) {
        try {
            this.cm.saveCustomer(customerParam);
        } catch (Exception eLoc) {
            return "FAILED";
        }
        return "OK";
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return this.cm.getAllCustomers();
    }

}
