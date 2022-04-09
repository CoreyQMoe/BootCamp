package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.EmployeeDAO;
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
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    //Initialize the page with a form
    @RequestMapping(value = "/employee/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("employee/register");

        RegisterFormBean form = new RegisterFormBean();

        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "employee/registerSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        if(bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("employee/register");
            return response;
        }
        Employee employee = employeeDAO.findEmployeeById(form.getId());

        if(employee == null) {
            employee = new Employee();
        }

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setPassword(form.getPassword());
        employee.setEmail(form.getEmail());
        employee.setPhoneNumber(form.getPhoneNumber());
        employee.setAddress1(form.getAddress1());
        employee.setAddress2(form.getAddress2());
        employee.setCity(form.getCity());
        employee.setState(form.getState());
        employee.setZipCode(form.getZipCode());
        employee.setReportsTo(employeeDAO.findEmployeeById(form.getReportsTo()));
        employee.setActive(1);
        employee.setCreated(new Date());
        employee.setUpdated(new Date());

        employeeDAO.save(employee);
        response.setViewName("employee/loginPage");
        return response;
    }
}
