package com.coreymoe.heroespos.database.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(columnDefinition = "Integer DEFAULT 1")
    private Integer active;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
}
