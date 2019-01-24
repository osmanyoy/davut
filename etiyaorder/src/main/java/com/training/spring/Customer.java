package com.training.spring;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Customer {

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Min(1)
    private int    age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }


}
