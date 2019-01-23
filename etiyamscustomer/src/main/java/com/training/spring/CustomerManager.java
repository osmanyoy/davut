package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {

    @Autowired
    private CustomerDAO cd;

    public void saveCustomer(final Customer customerParam) {
        this.cd.save(customerParam);
    }
}
