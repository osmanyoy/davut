package com.training.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRest {

    @Autowired
    private CustomerInt ci;

    @GetMapping("/myorder/allnames")
    public String getAllNames() {
        List<Customer> allCustomersLoc = this.ci.getAllCustomers();
        StringBuilder builderLoc = new StringBuilder();
        for (Customer customerLoc : allCustomersLoc) {
            builderLoc.append(customerLoc.getName());
            builderLoc.append(",");
        }
        return builderLoc.toString();
    }

    @PostMapping("/myorder/write")
    public String writeOrder(@RequestBody final Customer customerParam) {
        return this.ci.saveCustomer(customerParam);
    }

}
