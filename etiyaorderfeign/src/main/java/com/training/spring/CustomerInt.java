package com.training.spring;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ecms")
public interface CustomerInt {

    @PostMapping("/customer/add")
    public String saveCustomer(@RequestBody final Customer customerParam);

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers();

}
