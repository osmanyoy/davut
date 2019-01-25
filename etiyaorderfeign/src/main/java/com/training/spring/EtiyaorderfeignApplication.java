package com.training.spring;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EtiyaorderfeignApplication {


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

    public static void main(final String[] args) {
        SpringApplication.run(EtiyaorderfeignApplication.class,
                              args);
    }

}

