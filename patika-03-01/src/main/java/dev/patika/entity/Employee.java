package dev.patika.entity;

import lombok.*;

import javax.persistence.*;

// bütün yapılar lombok library den geliyor
// bunlar özelleştirilebilir.
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter

//@EqualsAndHashCode
//@ToString
//@Value // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsandHashCode, @ToString
@Data // --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsandHashCode, @ToString
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    private int age;
    @NonNull
    private double salary;
}

