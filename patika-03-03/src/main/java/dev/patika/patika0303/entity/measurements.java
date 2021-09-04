package dev.patika.patika0303.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class measurements {
    @Id
    private Long id;
    private String statistics;
    private double value;


}
