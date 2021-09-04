package dev.patika.patika0401.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.patika.patika0401.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet extends AbstractBaseEntity{

    private double balance;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private LocalDate createDate;

    @JsonBackReference
    @ManyToOne
    Customer customer;
}
