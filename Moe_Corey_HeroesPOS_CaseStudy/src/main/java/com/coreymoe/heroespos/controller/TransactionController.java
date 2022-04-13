package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.TransactionDAO;
import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class TransactionController {

    @Autowired
    private TransactionDAO transactionDAO;

    @RequestMapping(value="/searches/transactionSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("searches/transactionSearch");

        List<Transaction> transactions = transactionDAO.findAllTransactions();


        // very basic example of error checking
//        if (!StringUtils.isEmpty(firstName)) {
//            employees = employeeDAO.findByFirstNameIgnoreCaseContaining(firstName);
//        }

        response.addObject("transactions", transactions);

        return response;
    }
}
