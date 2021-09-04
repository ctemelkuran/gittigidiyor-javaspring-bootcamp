package dev.patika.patika0302.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends TodoBaseRequest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int todoInt;
    private int userId;
    private int id;
    private String title;
    private String completed;




}
