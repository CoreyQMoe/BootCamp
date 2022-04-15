package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SearchBean {

    @NotBlank(message = "Search field cannot be blank")
    private String searchCriteria;

    @NotNull(message = "Please choose a search field")
    private String searchRadio;
}
