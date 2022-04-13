package com.coreymoe.heroespos.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TransactionSearchBean {
    private Integer id;

    private Integer customerId;

    private Integer employeeId;

    private Double total;

    private String payment;

    private Date created;
}
