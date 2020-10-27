package by.jrr.reflections.bean;

import lombok.Data;

public class Car {
    public String model = "Tesla";
    private String privateModel = "TeslaPrivate";

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }


    public void getColorCode(String colorName) {
        System.out.println("getColorCode called with " + colorName);
    }

    private void getPrivateColorCode(String colorName) {
        System.out.println("getPrivateColorCode called with " + colorName);
    }

    public void getColorCode(String colorName, int palitra) {

    }
}
