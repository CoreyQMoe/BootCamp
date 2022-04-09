package com.coreymoe.heroespos.validation;

import com.coreymoe.heroespos.database.dao.EmployeeDAO;
import com.coreymoe.heroespos.database.entity.Employee;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImp implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImp.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isBlank(value)) {
            return true;
        }
        Employee employee = employeeDAO.findByEmail(value);
        return (employee == null);
    }

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

}
