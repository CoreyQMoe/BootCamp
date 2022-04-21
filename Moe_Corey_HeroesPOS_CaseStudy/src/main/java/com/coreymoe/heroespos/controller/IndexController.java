package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class IndexController {


    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/index/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDAO.findByEmail(currentPrincipalName);

        response.setViewName("/index/index");

        log.info("Someone has landed at the site.");

        return response;
    }

    @RequestMapping(value = "/index/landing", method = RequestMethod.GET)
    public ModelAndView landing() throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDAO.findByEmail(currentPrincipalName);

        log.info("User " + user.getEmail() + " has logged in.");

        response.setViewName("/index/landing");

        return response;
    }
}
