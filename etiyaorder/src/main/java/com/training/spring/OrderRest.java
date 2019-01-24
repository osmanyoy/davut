package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderRest {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/start/order")
    public String startOrder(@Validated @RequestBody final Customer customerParam) {
        String forObjectLoc = this.restTemplate.postForObject("http://ECMS/customer/add",
                                                              customerParam,
                                                              String.class);

        return forObjectLoc;
    }

}
