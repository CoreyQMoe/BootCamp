package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserSearchBean {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer phoneNumber;

    private Integer active;

    private Date created;
}
