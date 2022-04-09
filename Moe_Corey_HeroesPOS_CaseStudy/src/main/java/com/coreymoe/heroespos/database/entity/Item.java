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
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    @Column(
            nullable = false,
            unique = true
    )
    private String description;

    @Column(
            nullable = false
    )
    private Double price;

    @Column(
            nullable = false
    )
    private Double cost;

    @OneToOne
    private Department department;

    @Column(
            columnDefinition = "Integer DEFAULT 1"
    )
    private Integer active;

    @ManyToOne
    private Vendor vendor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
