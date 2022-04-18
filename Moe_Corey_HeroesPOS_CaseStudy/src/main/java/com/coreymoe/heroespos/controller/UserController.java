package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.dao.UserRolesDAO;
import com.coreymoe.heroespos.database.entity.User;
import com.coreymoe.heroespos.database.entity.UserRole;
import com.coreymoe.heroespos.formbean.EditUserBean;
import com.coreymoe.heroespos.formbean.RegisterFormBean;
import com.coreymoe.heroespos.formbean.SearchBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRolesDAO userRolesDAO;

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

    @RequestMapping(value = "user/registerSubmit", method = {RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if(bindingResult.hasErrors()) {

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
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());
        user.setActive(1);
        user.setCreated(LocalDate.now());

        userDAO.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRolesDAO.save(userRole);

        response.setViewName("redirect:/login/login");
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/search/userSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/userSearch");

        List<User> users = userDAO.findAllUsers();

        response.addObject("users", users);

        return response;
    }

    @RequestMapping(value="/search/userSearchSubmit", method= RequestMethod.GET )
    public ModelAndView searchSubmit(@Valid SearchBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/userSearch");
        List<User> users = new ArrayList<>();

        if(bindingResult.hasErrors()) {

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            users = userDAO.findAllUsers();

            response.addObject("users", users);
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        switch (form.getSearchRadio()) {
            case "id": users.add(userDAO.findUserById(Integer.parseInt(form.getSearchCriteria())));
                break;
            case "firstName": users = userDAO.findByFirstNameIgnoreCaseContaining(form.getSearchCriteria());
                break;
            case "lastName": users = userDAO.findByLastNameIgnoreCaseContaining(form.getSearchCriteria());
                break;
            case "email": users = userDAO.findByEmailIgnoreCaseContaining(form.getSearchCriteria());
                break;
            case "phoneNumber": users = userDAO.findUsersByPhoneNumberContaining(form.getSearchCriteria());
                break;
            case "active": users = userDAO.findByActive(Integer.parseInt(form.getSearchCriteria()));
                break;
            case "created": users = userDAO.findByCreated(form.getSearchCriteria());
                break;
        }

        response.addObject("users", users);

        return response;
    }

    @GetMapping("/edit/editUser/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();

        User user = userDAO.findUserById(userId);

        EditUserBean form = new EditUserBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
//        form.setPassword(user.getPassword());
//        form.setConfirmPassword(user.getPassword());
        form.setAddress(user.getAddress());
        form.setCity(user.getCity());
        form.setState(user.getState());
        form.setZipCode(user.getZipCode());
        form.setPhoneNumber(user.getPhoneNumber());
        form.setActive(user.getActive());

        response.addObject("form", form);
        response.setViewName("edit/editUser");
        return response;
    }

    @PostMapping("/edit/editUserSubmit/{userId}")
    public ModelAndView editUserSubmit(@Valid EditUserBean form, @PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();

        User user = userDAO.findUserById(userId);

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
//        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setPhoneNumber(form.getPhoneNumber());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());

        userDAO.save(user);

        response.addObject("form", form);
        response.setViewName("redirect:/edit/editUser/" + userId);

        return response;
    }

    @RequestMapping(value = "/edit/flipUserActivation/{userId}")
    public ModelAndView flipActivation(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();

        User user = userDAO.findUserById(userId);

        if(user.getActive() == 1) {
            user.setActive(0);
        } else {
            user.setActive(1);
        }

        userDAO.save(user);

        response.setViewName("redirect:/search/userSearch");
        return response;
    }
}
