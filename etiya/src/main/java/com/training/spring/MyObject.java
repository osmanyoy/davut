package com.training.spring;

import org.springframework.stereotype.Component;

@Component
public class MyObject {

    private String nameString;

    public void printName() {
        System.out.println(this.getNameString());
    }

    public String getNameString() {
        return this.nameString;
    }

    public void setNameString(final String nameStringParam) {
        this.nameString = nameStringParam;
    }
}
