package by.jrr.annotations.logger.bean;

import by.jrr.annotations.logger.example.MyLogger;

@MyLogger
public class Human{
    private String humanName;
    private String humanLastName;

    public Human(String humanName, String humanLastName) {
        this.humanName = humanName;
        this.humanLastName = humanLastName;
    }
}
