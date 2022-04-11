package com.coreymoe.heroespos.validation;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImp implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImp.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isBlank(value)) {
            return true;
        }
        User user = userDAO.findByEmail(value);
        return (user == null);
    }

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

}
