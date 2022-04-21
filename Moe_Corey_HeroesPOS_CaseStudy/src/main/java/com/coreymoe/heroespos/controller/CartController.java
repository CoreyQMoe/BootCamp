package com.coreymoe.heroespos.controller;

import com.coreymoe.heroespos.database.dao.ItemDAO;
import com.coreymoe.heroespos.database.dao.TransactionDAO;
import com.coreymoe.heroespos.database.dao.TransactionDetailDAO;
import com.coreymoe.heroespos.database.dao.UserDAO;
import com.coreymoe.heroespos.database.entity.Item;
import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.TransactionDetail;
import com.coreymoe.heroespos.database.entity.User;
import com.coreymoe.heroespos.formbean.CartBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        TransactionDetail currentDetail;
        User user;
        Transaction currentCart;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        user = userDAO.findByEmail(username);

        currentCart = transactionDAO.findPendingTransactionByUserId(user.getId());
        if (currentCart == null) {
            currentCart = new Transaction();
            transactionDAO.save(currentCart);
            currentCart.setUser(user);
            currentCart.setStatus("PENDING");
            currentCart.setTotal(0.00D);
            currentCart.setCreated(LocalDate.now());
            transactionDAO.save(currentCart);
            log.info("Transaction " + currentCart.getId() + " has been created.");
        }

        currentDetail = transactionDetailDAO.findTransactionDetailByTransactionIdAndItemId(currentCart.getId(), itemId);
        if (currentDetail == null) {
            currentDetail = new TransactionDetail();
            transactionDetailDAO.save(currentDetail);
            currentDetail.setTransaction(currentCart);
            currentDetail.setItem(itemDAO.findItemById(itemId));
            currentDetail.setQuantity(1);
            transactionDetailDAO.save(currentDetail);
            currentCart.getDetails().add(currentDetail);
            log.info("Transaction details for item " + itemId + " has been created for transaction " + currentCart.getId());
        } else {
            currentDetail.setQuantity(currentDetail.getQuantity() + 1);
            transactionDetailDAO.save(currentDetail);
            List<TransactionDetail> details = currentCart.getDetails();
            for (int i = 0; i < details.size(); i++) {
                if (details.get(i).getItem() == itemDAO.findItemById(itemId)) {
                    details.set(i, currentDetail);
                }
            }
            log.info("Quantity has been increased for " + itemId + " in transaction " + currentCart.getId());
        }

        response.setViewName("redirect:/search/itemSearch");

        return response;
    }

    @GetMapping("/cart/cart")
    public ModelAndView getCart() throws Exception {
        ModelAndView response = new ModelAndView();
        String username;
        List<TransactionDetail> currentDetails;
        User user;
        Transaction currentCart;
        List<Double> costs = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        Double tax = 0.0D;
        Double subtotal = 0.0D;
        Double total = 0.0D;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        user = userDAO.findByEmail(username);

        currentCart = transactionDAO.findPendingTransactionByUserId(user.getId());
        currentDetails = currentCart.getDetails();

        currentDetails.forEach((detail) -> {
            costs.add(detail.getItem().getPrice() * detail.getQuantity());
            items.add(detail.getItem());
            quantities.add(detail.getQuantity());
        });

        for (Double cost : costs) {
            subtotal += cost;
        }

        subtotal = Math.round(subtotal * 100.0) / 100.0;
        tax = Math.round((subtotal * 0.06875) * 100.0) / 100.0;
        total = subtotal + tax;

        log.info("User " + username + " has opened the cart page.");

        response.addObject("subtotal", subtotal);
        response.addObject("tax", tax);
        response.addObject("total", total);
        response.addObject("items", items);
        response.addObject("costs", costs);
        response.addObject("quantities", quantities);
        response.addObject("transactionID", currentCart.getId());
        response.setViewName("/cart/cart");

        return response;
    }

    @PostMapping("/cart/cartSubmit")
    public ModelAndView cartSubmit(@RequestParam(name = "differentAddress", required = false) String differentAddress, @Valid CartBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        response.setViewName("/cart/cart");

        String username;
        List<TransactionDetail> currentDetails;
        User user;
        Transaction currentCart;
        List<Double> costs = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        Double tax = 0.0D;
        Double subtotal = 0.0D;
        Double total = 0.0D;
        StringBuffer orderOutput = new StringBuffer();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        user = userDAO.findByEmail(username);

        currentCart = transactionDAO.findPendingTransactionByUserId(user.getId());
        currentDetails = currentCart.getDetails();

        currentDetails.forEach((detail) -> {
            costs.add(detail.getItem().getPrice() * detail.getQuantity());
            items.add(detail.getItem());
            quantities.add(detail.getQuantity());
        });

        for (Double cost : costs) {
            subtotal += cost;
        }

        subtotal = Math.round(subtotal * 100.0) / 100.0;
        tax = Math.round((subtotal * 0.06875) * 100.0) / 100.0;
        total = subtotal + tax;

        if (bindingResult.hasErrors()) {

            log.error("There were errors inputting information on the cart page.");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("subtotal", subtotal);
            response.addObject("tax", tax);
            response.addObject("total", total);
            response.addObject("items", items);
            response.addObject("costs", costs);
            response.addObject("quantities", quantities);
            response.addObject("transactionID", currentCart.getId());
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        log.info("User " + username + " has submitted payment.");

        orderOutput.append("For User: ").append(user).append("\n");
        orderOutput.append("Order number: ").append(currentCart.getId()).append("\n");
        if (differentAddress != null) {
            orderOutput.append("Address: ").append(form.getAltAddress()).append("\n");
            orderOutput.append(form.getAltCity()).append(", ").append(form.getAltState()).append(" ").append(form.getAltZip()).append("\n");
        } else {
            orderOutput.append("Address: ").append(user.getAddress()).append("\n");
            orderOutput.append(user.getCity()).append(", ").append(user.getState()).append(" ").append(user.getZipCode()).append("\n");
        }

        for (int i = 0; i < items.size(); i++) {
            orderOutput.append("Order: ").append(items.get(i).toString()).append(" Quantity: ").append(quantities.get(i))
                    .append(" For: ").append(costs.get(i)).append("\n");
        }
        orderOutput.append("Subtotal: ").append(subtotal).append("\n");
        orderOutput.append("Tax: ").append(tax).append("\n");
        orderOutput.append("Total: ").append(total).append("\n");
        orderOutput.append("Payment Information: ").append(form.getCreditCardType()).append(" ").append(form.getCreditCardNumber()).append("\n");
        orderOutput.append("EXP Date: ").append(form.getCreditCardExp()).append("  CSV: ").append(form.getCreditCardCSV()).append("\n\n");

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt", true));
            out.write(orderOutput.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Order payment has failed.");

            response.addObject("subtotal", subtotal);
            response.addObject("tax", tax);
            response.addObject("total", total);
            response.addObject("items", items);
            response.addObject("costs", costs);
            response.addObject("quantities", quantities);
            response.addObject("transactionID", currentCart.getId());
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        currentCart.setStatus("PAID");

        log.info("Order " + currentCart.getId() + " has been completed.");

        response.setViewName("redirect:/search/itemSearch");

        return response;
    }
}
