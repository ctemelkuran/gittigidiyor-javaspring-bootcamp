package dev.patika.patika0302.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class TodoBaseRequest {
    private LocalDate localDate;
}
