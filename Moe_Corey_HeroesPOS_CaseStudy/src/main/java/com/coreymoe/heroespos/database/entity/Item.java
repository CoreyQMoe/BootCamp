package com.coreymoe.heroespos.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
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

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Set<TransactionDetail> transactionDetails;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
