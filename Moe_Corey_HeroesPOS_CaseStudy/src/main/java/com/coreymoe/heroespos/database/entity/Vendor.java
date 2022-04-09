package com.coreymoe.heroespos.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendors")
public class Vendor {

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
            name = "rep_first_name",
            nullable = false
    )
    private String repFirstName;

    @Column(
            name = "rep_last_name",
            nullable = false
    )
    private String repLastName;

    @Column(
            name = "rep_email",
            nullable = false
    )
    private String repEmail;

    @Column(
            name = "rep_phone_number",
            nullable = false
    )
    private Integer repPhoneNumber;

    @Column(
            columnDefinition = "Integer DEFAULT 1"
    )
    private Integer active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
