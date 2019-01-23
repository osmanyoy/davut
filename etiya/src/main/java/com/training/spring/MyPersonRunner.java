package com.training.spring;


public class MyPersonRunner {

    public static void main(final String[] args) {

        MyPerson myPersonLoc = MyPerson.getBuilder()
                                       .withName("osman")
                                       .withSurnname("yay")
                                       .build();


    }
}
