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
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active;
    @ManyToOne
    private Vendor vendor;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date created;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date updated;
}
