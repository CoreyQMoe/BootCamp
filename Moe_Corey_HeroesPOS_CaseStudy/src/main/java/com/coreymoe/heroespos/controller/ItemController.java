package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.ItemDAO;
import com.coreymoe.heroespos.database.entity.Item;
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
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(value="/search/itemSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/itemSearch");

        List<Item> items = itemDAO.findAllItems();

        response.addObject("items", items);

        return response;
    }

    @RequestMapping(value="/search/itemSearchSubmit", method= RequestMethod.GET )
    public ModelAndView searchSubmit(@Valid SearchBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/itemSearch");
        List<Item> items = new ArrayList<>();

        if(bindingResult.hasErrors()) {

            for(ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError)error).getField() + " " + error.getDefaultMessage());
            }

            items = itemDAO.findAllItems();

            response.addObject("items", items);
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        switch (form.getSearchRadio()) {
            case "id": items.add(itemDAO.findById(Integer.parseInt(form.getSearchCriteria())));
                break;
            case "name": items = itemDAO.findByNameIgnoreCaseContaining(form.getSearchCriteria());
                break;
            case "description": items = itemDAO.findByDescriptionIgnoreCaseContaining(form.getSearchCriteria());
                break;
            case "price": items = itemDAO.findByPrice(Double.parseDouble(form.getSearchCriteria()));
                break;
            case "active": items = itemDAO.findByActive(Integer.parseInt(form.getSearchCriteria()));
                break;
            case "created": items = itemDAO.findByCreated(form.getSearchCriteria());
                break;
        }

        response.addObject("items", items);

        return response;
    }
}
