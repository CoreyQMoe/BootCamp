package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class ItemBean {

    private Integer id;

    @NotBlank(message = "Item name cannot be blank")
    private String name;

    @NotBlank(message = "Item description cannot be blank")
    private String description;

    @NotBlank(message = "Item price cannot be blank")
    @Pattern(regexp = "\\d+\\.\\d{2}", message = "Price is in the wrong format")
    private String price;

    private Integer active;
}
