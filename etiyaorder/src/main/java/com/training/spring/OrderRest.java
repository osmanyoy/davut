package com.training.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class OrderRest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;


    @PostMapping("/start/order")
    public String startOrder(@Validated @RequestBody final Customer customerParam) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Content-Type",
                "application/json");
        HttpHeaders headersLoc = new HttpHeaders(map);

        HttpEntity<Customer> entityLoc = new HttpEntity<>(customerParam,
                                                          headersLoc);

        String forObjectLoc = this.restTemplate.postForObject("http://ECMS/customer/add",
                                                              entityLoc,
                                                              String.class);

        return forObjectLoc;
    }

    @PostMapping("/start/order2")
    public String startOrder2(@Validated @RequestBody final Customer customerParam) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Content-Type",
                "application/json");
        HttpHeaders headersLoc = new HttpHeaders(map);

        HttpEntity<Customer> entityLoc = new HttpEntity<>(customerParam,
                                                          headersLoc);

        InstanceInfo nextServerFromEurekaLoc = this.eurekaClient.getNextServerFromEureka("ecms",
                                                                                         false);

        String stringLoc = nextServerFromEurekaLoc.getHomePageUrl() + "/customer/add";

        String forObjectLoc = this.restTemplate.postForObject(stringLoc,
                                                              entityLoc,
                                                              String.class);

        return forObjectLoc;
    }

    @Autowired
    private RabbitTemplate rt;

    @PostMapping("/async/start/order")
    public String startAsyncOrder(@Validated @RequestBody final Customer customerParam) {
        this.rt.convertAndSend("eorderreq",
                               "reqorder",
                               customerParam);

        return "OK";
    }


}
