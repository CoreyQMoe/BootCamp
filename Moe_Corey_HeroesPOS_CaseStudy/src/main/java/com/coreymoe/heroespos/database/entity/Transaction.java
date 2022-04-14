package com.coreymoe.heroespos.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private Double total;

    private String payment;

    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonManagedReference solves infinite looping
    private Set<TransactionDetail> details;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated;
}
