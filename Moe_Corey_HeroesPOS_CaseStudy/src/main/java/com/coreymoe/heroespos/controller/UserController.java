package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.dao.UserRolesDAO;
import com.coreymoe.heroespos.database.entity.User;
import com.coreymoe.heroespos.database.entity.UserRole;
import com.coreymoe.heroespos.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        user.setCreated(new Date());
        user.setUpdated(new Date());

        userDAO.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRolesDAO.save(userRole);

        response.setViewName("redirect:/login/login");
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/admin/userSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/userSearch");

        List<User> users = userDAO.findAllUsers();


        // very basic example of error checking
//        if (!StringUtils.isEmpty(firstName)) {
//            employees = employeeDAO.findByFirstNameIgnoreCaseContaining(firstName);
//        }

        response.addObject("users", users);

        return response;
    }
/**
 * Work on editing users later
 */
//    @GetMapping("/user/edit/{userId}")
//    //public ModelAndView editUser(@RequestParam("userId") Integer userId) throws Exception {
//    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("user/register");
//
//        User user = userDAO.findUserById(userId);
//
//        RegisterFormBean form = new RegisterFormBean();
//
//        form.setId(user.getId());
//        form.setEmail(user.getEmail());
//        form.setFirstName(user.getFirstName());
//        form.setLastName(user.getLastName());
//        form.setPassword(PasswordEncoder. user.getPassword());
//        form.setConfirmPassword(user.getPassword());
//        form.setAddress(user.getAddress());
//        form.setCity(user.getCity());
//        form.setState(user.getState());
//        form.setZipCode(user.getZipCode());
//        form.setPhoneNumber(user.getPhoneNumber());
//
//        // in this case we are adding the RegisterFormBean to the model
//        response.addObject("form", form);
//
//        return response;
//    }
}
