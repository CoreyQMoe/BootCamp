package com.coreymoe.heroespos.formbean;

import com.coreymoe.heroespos.database.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserSearchBean {
    private List<User> users;
}
