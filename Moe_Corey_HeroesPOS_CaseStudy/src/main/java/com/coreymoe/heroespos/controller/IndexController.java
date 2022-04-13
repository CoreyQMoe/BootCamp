package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/index/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        // this little block of code can grab the logged in user and look it up in the
        // database to get the user object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDAO.findByEmail(currentPrincipalName);

        if ( loggedInUser == null ) {
            log.debug("Not logged in");
        } else {
            log.debug("User logged in " + loggedInUser);
        }

        response.setViewName("/index/index");

        return response;
    }

}
