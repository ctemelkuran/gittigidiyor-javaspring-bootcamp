package dev.patika.patika0303.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;


public class ProcessStartTime {
    private String name;
    private String description;
    private String baseUnit;
    private LocalDateTime localDateTime;
    private measurements measurements;
}
