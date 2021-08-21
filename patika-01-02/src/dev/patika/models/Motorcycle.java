package dev.patika.models;

import javax.persistence.Entity;

@Entity

public class Motorcycle extends Vehicle{
    private double engine_power;

    public Motorcycle(int v_year, String v_model, String v_plate, double engine_power) {
        super(v_year, v_model, v_plate);
        this.engine_power = engine_power;
    }

    public Motorcycle(double engine_power) {
        this.engine_power = engine_power;
    }

    public Motorcycle(){}

    public double getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(double engine_power) {
        this.engine_power = engine_power;
    }
}
