package com.training.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {

    @Autowired
    private CustomerDAO cd;

    public void saveCustomer(final Customer customerParam) {
        this.cd.save(customerParam);
    }

    public List<Customer> getAllCustomers() {
        Iterable<Customer> findAllLoc = this.cd.findAll();
        List<Customer> customersLoc = new ArrayList<>();
        for (Customer customerLoc : findAllLoc) {
            customersLoc.add(customerLoc);
        }
        return customersLoc;
    }
}
