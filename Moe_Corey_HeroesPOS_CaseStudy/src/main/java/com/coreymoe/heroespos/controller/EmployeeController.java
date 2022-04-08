package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.EmployeeDAO;
import com.coreymoe.heroespos.database.entity.Customer;
import com.coreymoe.heroespos.database.entity.Employee;
import com.coreymoe.heroespos.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private EmployeeDAO employeeDAO;

    //Initialize the page with a form
    @RequestMapping(value = "/employee/registrationPage", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("employee/registrationPage");

        RegisterFormBean form = new RegisterFormBean();

        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "employee/registerSubmit", method = {RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if(bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("employee/registrationPage");
            return response;
        }

        Employee employee = employeeDAO.findById((Long)form.getId());

        if(customer == null) {
            customer = new Customer();
        }

        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setP
        customer.setAddress1(form.getAddress1());
        customer.setAddress2(form.getAddress2());
        customer.set
    }
}
