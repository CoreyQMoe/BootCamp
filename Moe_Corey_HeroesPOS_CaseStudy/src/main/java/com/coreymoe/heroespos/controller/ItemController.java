package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.ItemDAO;
import com.coreymoe.heroespos.database.entity.Item;
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
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(value="/searches/itemSearch", method= RequestMethod.GET )
    public ModelAndView search() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("searches/itemSearch");

        List<Item> items = itemDAO.findAllItems();


        // very basic example of error checking
//        if (!StringUtils.isEmpty(firstName)) {
//            employees = employeeDAO.findByFirstNameIgnoreCaseContaining(firstName);
//        }

        response.addObject("items", items);

        return response;
    }
}
