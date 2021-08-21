package dev.patika.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int v_year;
    private String v_model;
    private String v_plate;

    public Vehicle(int v_year, String v_model, String v_plate) {
        this.v_year = v_year;
        this.v_model = v_model;
        this.v_plate = v_plate;
    }

    public Vehicle(){}

    @ManyToMany

    private List<Accident> accidents = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    public int getV_year() {
        return v_year;
    }

    public void setV_year(int v_year) {
        this.v_year = v_year;
    }

    public String getV_model() {
        return v_model;
    }

    public void setV_model(String v_model) {
        this.v_model = v_model;
    }

    public String getV_plate() {
        return v_plate;
    }

    public void setV_plate(String v_plate) {
        this.v_plate = v_plate;
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(v_plate, vehicle.v_plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v_plate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "v_year=" + v_year +
                ", v_model='" + v_model + '\'' +
                ", v_plate='" + v_plate + '\'' +
                '}';
    }
}
