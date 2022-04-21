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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

        response.setViewName("user/register");
        response.addObject("form", form);

        log.info("The registration page has been accessed.");

        return response;
    }

    @RequestMapping(value = "user/registerSubmit", method = {RequestMethod.POST})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if(bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the registration page.");

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

        log.info("User " + user.getEmail() + " has been created.");

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

        log.info("The user search page has been accessed.");

        return response;
    }

    @RequestMapping(value="/search/userSearchSubmit", method= RequestMethod.GET )
    public ModelAndView searchSubmit(@Valid SearchBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/userSearch");
        List<User> users = new ArrayList<>();

        if(bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the user search page.");

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

        log.info("User search has completed.");

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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

        log.info("The edit user page has been accessed for user " + userId + ".");

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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

        log.info("User " + userId + " has been updated.");

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
            log.info("User " + userId +" has been marked inactive");
        } else {
            user.setActive(1);
            log.info("User " + userId +" has been marked active");
        }

        userDAO.save(user);

        response.setViewName("redirect:/search/userSearch");
        return response;
    }

    @GetMapping("/edit/profile")
    public ModelAndView profile() throws Exception {
        ModelAndView response = new ModelAndView();
        User user;
        EditUserBean form = new EditUserBean();
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        user = userDAO.findByEmail(username);

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

        log.info("The edit user page has been access for user " + user.getId() + ".");

        return response;
    }
}
