package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.TransactionDAO;
import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.formbean.SearchBean;
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
public class TransactionController {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="/search/transactionSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/transactionSearch");

        List<Transaction> transactions = transactionDAO.findAllTransactions();

        response.addObject("transactions", transactions);

        log.info("The transaction search page has been accessed.");

        return response;
    }

    @RequestMapping(value="/search/transactionSearchSubmit", method= RequestMethod.GET )
    public ModelAndView searchSubmit(@Valid SearchBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();

        List<Transaction> transactions = new ArrayList<>();

        if(bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the transaction search page.");

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            transactions = transactionDAO.findAllTransactions();

            response.addObject("transactions", transactions);
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        switch (form.getSearchRadio()) {
            case "id": transactions.add(transactionDAO.findTransactionById(Integer.parseInt(form.getSearchCriteria())));
                break;
            case "firstName": transactions = transactionDAO.findByUserFirstNameIgnoreCase(form.getSearchCriteria());
                break;
            case "lastName": transactions = transactionDAO.findByUserLastNameIgnoreCase(form.getSearchCriteria());
                break;
            case "total": transactions = transactionDAO.findByTotal(Double.parseDouble(form.getSearchCriteria()));
                break;
            case "status": transactions = transactionDAO.findByStatus(form.getSearchCriteria());
                break;
            case "created": transactions = transactionDAO.findByCreated(form.getSearchCriteria());
                break;
        }

        response.addObject("transactions", transactions);
        response.setViewName("search/transactionSearch");

        log.info("Transaction search has completed.");

        return response;
    }
}
