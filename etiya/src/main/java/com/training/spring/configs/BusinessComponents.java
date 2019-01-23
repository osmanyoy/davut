package com.training.spring.configs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.training.spring.MyPerson;
import com.training.spring.services.MyPersonManager;

import xyz.com.MySecondConfig;

@Configuration
@Import(MySecondConfig.class)
@EnableScheduling
@PropertySource("classpath:test.yml")
public class BusinessComponents {

    private final Map<String, MyPerson> myPersonMap = new HashMap<>();
    private long                        counter     = 0;

    @Bean
    public MyPersonManager myPersonManager() {
        return new MyPersonManager();
    }

    //    @Bean
    //    public MyPersonManager myPersonManager2(@Value("#{etiyaApplication.getMyObject()}") final MyObject mObject) {
    //        System.out.println("Prop1 : " + mObject);
    //        return new MyPersonManager();
    //    }

    @Scheduled(fixedDelay = 1000)
    public void runMe() {
        this.counter++;
        System.out.println("schedule : " + this.counter);
        this.myPersonMap.put("test" + this.counter,
                             MyPerson.getBuilder()
                                     .withName("osman" + this.counter)
                                     .withSurnname("yay")
                                     .build());
    }

}
