package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.ItemDAO;
import com.coreymoe.heroespos.database.entity.Item;
import com.coreymoe.heroespos.formbean.ItemBean;
import com.coreymoe.heroespos.formbean.SearchBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(value="/search/itemSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/itemSearch");

        List<Item> items = itemDAO.findAllItems();

        response.addObject("items", items);

        log.info("The item search page has been accessed.");

        return response;
    }

    @RequestMapping(value="/search/itemSearchSubmit", method= RequestMethod.GET )
    public ModelAndView searchSubmit(@Valid SearchBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("search/itemSearch");
        List<Item> items = new ArrayList<>();

        if(bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the item search page.");

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
            case "id": items.add(itemDAO.findItemById(Integer.parseInt(form.getSearchCriteria())));
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

        log.info("Item search complete.");

        return response;
    }

    @GetMapping("/edit/newItem")
    public ModelAndView newItem() {
        ModelAndView response = new ModelAndView();

        ItemBean form = new ItemBean();

        response.addObject("form", form);

        response.setViewName("edit/newItem");

        log.info("Item creation page has been accessed.");

        return response;
    }

    @RequestMapping(value="/edit/newItemSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView newItemSubmit(@Valid ItemBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if(bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the item creation page.");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("edit/newItem");
            return response;
        }

        Item item = itemDAO.findItemById(form.getId());

        if(item == null) {
            item = new Item();
        }

        item.setName(form.getName());
        item.setDescription(form.getDescription());
        item.setPrice(Double.parseDouble(form.getPrice()));
        item.setActive(form.getActive());
        item.setCreated(LocalDate.now());

        itemDAO.save(item);

        log.info("Item " + item.getId() + "has been updated.");

        response.setViewName("redirect:/search/itemSearch");

        return response;
    }

    @GetMapping("/edit/editItem/{itemId}")
    public ModelAndView editItem(@PathVariable("itemId") Integer itemId) throws Exception {
        ModelAndView response = new ModelAndView();

        Item item = itemDAO.findItemById(itemId);

        ItemBean form = new ItemBean();

        form.setId(itemId);
        form.setName(item.getName());
        form.setDescription(item.getDescription());
        form.setPrice(item.getPrice().toString());
        form.setActive((item.getActive()));

        response.addObject("form", form);
        response.setViewName("/edit/newItem");

        log.info("Item edit page has been accessed for item " + itemId + ".");

        return response;
    }

    @GetMapping("/edit/deleteItem/{itemId}")
    public ModelAndView deleteItem(@PathVariable("itemId") Integer itemId) throws Exception {
        ModelAndView response = new ModelAndView();

        itemDAO.deleteById(itemId);

        response.setViewName("redirect:/search/itemSearch");

        log.info("Item was deleted.");

        return response;
    }
}
