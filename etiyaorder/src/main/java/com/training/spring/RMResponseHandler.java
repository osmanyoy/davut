package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RMResponseHandler {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "etiyaorderresponse",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "eores_ex",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "eoresponse"))
    public void handle(final String string) {
        System.out.println(string);
    }

}
