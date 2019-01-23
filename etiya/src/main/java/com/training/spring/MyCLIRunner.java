package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCLIRunner implements CommandLineRunner {

    private final EtiyaApplication ea;


    @Autowired
    public MyCLIRunner(final EtiyaApplication ea) {
        MyObject myObjectLoc = ea.getMyObject();
        this.ea = ea;
    }

    @Override
    public void run(final String... argsParam) throws Exception {
        this.ea.getMyObject()
               .printName();
    }

}
