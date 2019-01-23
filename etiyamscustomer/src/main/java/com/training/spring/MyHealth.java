package com.training.spring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                     .withDetail("nedeni",
                                 new MyStatus("test",
                                              1000))
                     .build();
    }

}
