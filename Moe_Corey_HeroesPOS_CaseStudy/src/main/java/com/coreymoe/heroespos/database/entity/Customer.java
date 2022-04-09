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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    @Column(
            name = "first_name",
            nullable = false,
            length = 30
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = 30
    )
    private String lastName;

    @Column(
            nullable = false,
            length = 30
    )
    private String address1;

    @Column(
            nullable = false,
            length = 30
    )
    private String address2;

    @Column(
            nullable = false,
            length = 30
    )
    private String city;

    @Column(
            nullable = false,
            length = 30
    )
    private String state;

    @Column(
            name = "zip_code",
            nullable = false
    )
    private Integer zipCode;

    @Column(
            name = "phone_number",
            nullable = false
    )
    private Integer phoneNumber;

    @Column(
            nullable = false,
            length = 50
    )
    private String email;

    @Column(
            columnDefinition = "Integer DEFAULT 1"
    )
    private Integer active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
