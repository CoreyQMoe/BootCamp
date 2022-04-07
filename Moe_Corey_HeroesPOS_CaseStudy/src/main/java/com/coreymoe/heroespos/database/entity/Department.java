package com.coreymoe.heroespos.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "departments")
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date created;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date updated;

}
