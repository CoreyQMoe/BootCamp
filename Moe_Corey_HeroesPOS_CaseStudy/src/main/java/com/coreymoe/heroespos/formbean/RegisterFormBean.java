package com.coreymoe.heroespos.formbean;

import com.coreymoe.heroespos.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    @EmailUnique(message = "An Employee was found with that email.")
    private String email;

    private Integer phoneNumber;

    private String address1;

    private String city;

    private String state;

    private Integer zipCode;

    private Integer reportsTo;

    private List<Integer> ids;

    private List<String> fullNames;
}
