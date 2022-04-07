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
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
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
    private String email;
    @Column(
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active;
    @ManyToOne
    @JoinColumn(
            name = "reports_to_employee_id"
    )
    private Employee reportsTo;
    @OneToOne
    private Password password;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date created;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date updated;
}
