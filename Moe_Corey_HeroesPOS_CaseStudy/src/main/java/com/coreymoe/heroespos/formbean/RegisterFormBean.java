package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    private String email;

    private Integer phoneNumber;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private Integer zipCode;

    private Integer reportsTo;

}
