package com.coreymoe.heroespos.formbean;

import com.coreymoe.heroespos.database.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserSearchBean {

    private String firstName;

    private String lastName;

    private String email;

    private Integer phoneNumber;

    private Integer active;

    private Date created;

    private List<User> users;
}
