package com.udemy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    @NotNull
    @Size(min = 2, max = 6)
    private String name;

    @NotNull
    @Min(18)
    private int age;

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        super();
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}