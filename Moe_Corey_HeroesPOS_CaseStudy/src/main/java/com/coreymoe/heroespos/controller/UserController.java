package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.User;
import com.coreymoe.heroespos.formbean.RegisterFormBean;
import com.coreymoe.heroespos.formbean.UserSearchBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    //Initialize the page with a form
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();
        RegisterFormBean form = new RegisterFormBean();

        List<String> firstNames = userDAO.getAllUserFirstNames();
        List<String> lastNames = userDAO.getAllUserLastNames();
        List<String> fullNames = new ArrayList<>();

        for (int i = 0; i < firstNames.size(); i++) {
            fullNames.add(firstNames.get(i) + " " + lastNames.get(i));
        }
        form.setFullNames(fullNames);

        response.setViewName("user/register");
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "user/registerSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        if(bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("user/register");
            return response;
        }
        User user = userDAO.findUserById(form.getId());

        if(user == null) {
            user = new User();
        }

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setAddress1(form.getAddress1());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());
        user.setActive(1);
        user.setCreated(new Date());
        user.setUpdated(new Date());

        userDAO.save(user);
        response.setViewName("user/loginPage");
        return response;
    }

    @RequestMapping(value="/searches/userSearch", method= RequestMethod.GET )
    public ModelAndView search(@RequestParam(value = "firstName", required = false) String firstName) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("searches/userSearch");

        List<User> users = userDAO.findAllUsers();


        // very basic example of error checking
//        if (!StringUtils.isEmpty(firstName)) {
//            employees = employeeDAO.findByFirstNameIgnoreCaseContaining(firstName);
//        }

        response.addObject("users", users);

        return response;
    }
}
