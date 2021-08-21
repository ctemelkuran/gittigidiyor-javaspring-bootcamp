package dev.patika.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDate accident_date;

    @ManyToMany(mappedBy = "")
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Accident(LocalDate accident_date) {
        this.accident_date = accident_date;
    }

    public Accident(){}

    public LocalDate getAccident_date() {
        return accident_date;
    }

    public void setAccident_date(LocalDate accident_date) {
        this.accident_date = accident_date;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accident_date=" + accident_date +
                '}';
    }
}
