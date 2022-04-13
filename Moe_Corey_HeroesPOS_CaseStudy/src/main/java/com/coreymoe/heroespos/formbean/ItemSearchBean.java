package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ItemSearchBean {

    private Integer id;

    private String name;

    private String description;

    private Integer price;

    private Integer active;

    private Date created;
}
