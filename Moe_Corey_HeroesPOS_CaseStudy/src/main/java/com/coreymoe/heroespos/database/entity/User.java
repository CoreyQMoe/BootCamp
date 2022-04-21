package com.coreymoe.heroespos.database.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

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

    @Column(name = "phone_number",
            nullable = false)
    private String phoneNumber;

    @Column(length = 30)
    private String address;

    @Column(length = 50)
    private String city;

    @Column(length = 15)
    private String state;

    @Column(name = "zip_code", length = 5)
    private Integer zipCode;

    @Column(name="active", columnDefinition = "BIT")
    private Integer active;

    @Column(length = 20)
    private String password;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private Set<Transaction> transactions;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
}
