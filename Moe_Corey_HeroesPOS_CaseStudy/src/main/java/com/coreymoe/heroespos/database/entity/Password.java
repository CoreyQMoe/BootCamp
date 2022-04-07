package com.coreymoe.heroespos.database.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String password;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date created;
    @Column(
            columnDefinition = "DATETIME DEFAULT current_timestamp()"
    )
    private Date updated;
}
