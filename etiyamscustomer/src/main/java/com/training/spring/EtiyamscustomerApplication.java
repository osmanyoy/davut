package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
@EnableEurekaClient

public class EtiyamscustomerApplication {

    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
        CommonsRequestLoggingFilter filterLoc = new CommonsRequestLoggingFilter();
        filterLoc.setIncludeHeaders(true);
        filterLoc.setIncludePayload(true);
        filterLoc.setIncludeQueryString(true);
        filterLoc.setIncludeClientInfo(true);
        return filterLoc;
    }

    public static void main(final String[] args) {
        SpringApplication.run(EtiyamscustomerApplication.class,
                              args);
    }

}

