package by.jrr.annotations.logger.bean;

import by.jrr.annotations.logger.example.MyLogger;

@MyLogger
public class Person {
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
