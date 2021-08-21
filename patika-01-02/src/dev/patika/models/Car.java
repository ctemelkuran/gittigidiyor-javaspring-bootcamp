package dev.patika.models;

import javax.persistence.Entity;

@Entity

public class Car extends  Vehicle {
    private String color;

    public Car(int v_year, String v_model, String v_plate, String color) {
        super(v_year, v_model, v_plate);
        this.color = color;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
