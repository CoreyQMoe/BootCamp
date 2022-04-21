package com.coreymoe.heroespos.formbean;

import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.TransactionDetail;
import com.coreymoe.heroespos.database.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString
public class CartBean {

    private String creditCardType;

    @Pattern(regexp = "\\d+", message = "Credit card number can contain only numbers")
    private String creditCardNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$", message = "Expiration date format should be MM/YY")
    private String creditCardExp;

    @Pattern(regexp = "[0-9]{3}|[0-9]{4}", message = "CSV code must contain three or four numbers")
    private String creditCardCSV;

    private String altAddress;

    private String altCity;

    @Pattern(regexp = "[a-zA-Z]{2}", message = "Enter two character state identifier")
    private String altState;

    @Range(min = 501, max = 99950)
    private Integer altZip;
}
