package com.training.spring;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class GeneralConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate jsonRabbitTemplate(final ConnectionFactory connectionFactoryParam) {
        RabbitTemplate rabbitTemplateLoc = new RabbitTemplate(connectionFactoryParam);
        rabbitTemplateLoc.setMessageConverter(this.jsonMessageConverter());
        return rabbitTemplateLoc;
    }

}
