package com.training.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
                                            "com.training.spring",
                                            "xyz.com"
})
@ServletComponentScan
public class EtiyaApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(EtiyaApplication.class);

    @Autowired
    private MyObject            myObject;

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(EtiyaApplication.class,
                                                                      args);
        EtiyaApplication beanLoc = runLoc.getBean(EtiyaApplication.class);
        beanLoc.getMyObject()
               .setNameString("osman");
        beanLoc.getMyObject()
               .printName();


        //        MyObject myObjectLoc = new MyObject();
        //        myObjectLoc.setNameString("osman");
        //        myObjectLoc.printName();
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        if (EtiyaApplication.logger.isDebugEnabled()) {
            EtiyaApplication.logger.debug("My Run method called : " + argsParam + " My object " + this.getMyObject());
        }
        this.getMyObject()
            .setNameString("osman");
        this.getMyObject()
            .printName();

    }

    public MyObject getMyObject() {
        return this.myObject;
    }

}

