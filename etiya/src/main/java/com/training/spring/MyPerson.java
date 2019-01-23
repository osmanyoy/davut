package com.training.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@Entity
public final class MyPerson {

    //    @Id
    //    @GeneratedValue
    private long   pId;

    @NotNull
    @Size(min = 2, max = 30, message = "Error yanlış")
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @Max(120)
    private int    age;

    public long getpId() {
        return this.pId;
    }

    public void setName(final String nameParam) {

        this.name = nameParam;
    }


    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }


    public void setAge(final int ageParam) {
        this.age = ageParam;
    }


    public static MyPersonBuilder getBuilder() {
        return new MyPersonBuilder();
    }

    public static class MyPersonBuilder {

        private final MyPerson myPerson = new MyPerson();


        private MyPersonBuilder() {
        }

        public MyPersonBuilder withName(final String name) {
            this.myPerson.name = name;
            return this;
        }

        public MyPersonBuilder withSurnname(final String surnname) {
            this.myPerson.surname = surnname;
            return this;
        }

        public MyPersonBuilder withAge(final int age) {
            this.myPerson.age = age;
            return this;
        }

        public MyPerson build() {
            // Validations
            return this.myPerson;
        }


    }

    public String getName() {
        return this.name;
    }


    public String getSurname() {
        return this.surname;
    }


    public int getAge() {
        return this.age;
    }

}
