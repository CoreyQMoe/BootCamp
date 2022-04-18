package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.ItemDAO;
import com.coreymoe.heroespos.database.dao.TransactionDAO;
import com.coreymoe.heroespos.database.dao.TransactionDetailDAO;
import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CartController {

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    TransactionDetailDAO transactionDetailDAO;

    @Autowired
    UserDAO userDAO;

    @GetMapping("/cart/addToCart/{itemId}")
    public ModelAndView addToCart(@PathVariable("itemId") Integer itemId) throws Exception {
        ModelAndView response = new ModelAndView();
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDAO.findByEmail(username);

        Transaction currentCart = transactionDAO.findPendingTransactionByUserId(user.getId());

        if(currentCart == null) {
            currentCart = new Transaction();
        }



        response.setViewName("redirect:/search/itemSearch");

        return response;
    }
}
