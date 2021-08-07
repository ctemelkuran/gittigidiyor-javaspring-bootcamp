package dev.patika;

import java.util.Objects;

public class Circle {
    //extends Object default tır
    // instance variables (fields) yukarda tanımlanır
    private double radius;
    private String color;


    // constructors
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }
    // Bunlar overloading

    // custom methods
    public double getArea(){
        double result = Math.PI * Math.pow(this.getRadius(),2);
        return result;
    }

    // getters & setters

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // equals & hashCode & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(color, circle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
