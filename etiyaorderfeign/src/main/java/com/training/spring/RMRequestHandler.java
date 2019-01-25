package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class RMRequestHandler {

    @Autowired
    private CustomerInt ci;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "etiyaorderrequest",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "eorderreq",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "reqorder"))
    @SendTo("eores_ex/eoresponse")
    public String handle(final Customer customerParam) {
        String saveCustomerLoc = this.ci.saveCustomer(customerParam);
        System.out.println(saveCustomerLoc);
        return saveCustomerLoc;
    }

}
