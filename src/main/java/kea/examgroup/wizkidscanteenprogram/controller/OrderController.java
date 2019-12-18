package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Order;

import kea.examgroup.wizkidscanteenprogram.repository.OrderRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Date;

/*
* Authors: Rasmus, Mathias and Oliver
*
* The primary controller class for the order handling.
* From here it will be possible to create, get and eventually
* edit the orders both for admins but also for normal Wizkids users.
 */

@Controller
public class OrderController {


    @Autowired
    private WizkidsUserRepository wizkidsUserRepository;
    @Autowired
    private OrderRepository orderRepository;


    // GET mapping which handles the creation of a new order.
    @RequestMapping(value = "/createorder/{menuId}", method = RequestMethod.GET)
    public ModelAndView createOrder(@PathVariable("menuId") @Valid @ModelAttribute long menuId, Order order) {

        // Importing authenticaion to get access to the username of the current user.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Importing date to be able to get the current date and time for the order.
        Date date = new Date();

        // Saving values to some individual variables in the order object.
        order.setDate(date);
        order.setWizkidsUserId(wizkidsUserRepository.findUserByUsername(authentication.getName()).getId());
        order.setMenuId(menuId);

        // Using the crud repository to save the object to the database
        orderRepository.save(order);

        // Returning the user to the personel menu page.
        return new ModelAndView(
                new RedirectView("/personelmenu?menuordered", true));
    }

    // GET mapping which gets all the orders for the user current logged in
    @GetMapping("/personelorders")
    public String toPersonelOrders(Model model) {

        // Importing authenticaion to get access to the username of the current user.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Uses the crud repository to get all the orders which has the userId, that we get from the current user.
        Iterable<Order> orderList = orderRepository.findAllByWizkidsUserId((
                wizkidsUserRepository.findUserByUsername(authentication.getName()).getId()));

        // Inserts the orders from the database to a model which we pull the data from in the HTML file.
        model.addAttribute("orders", orderList);

        // Forwards the user to the HTML page personelorders
        return "/personelorders";
    }

    // GET mapping which gets all the orders made.
    @GetMapping("/canteenorders")
    public String toCanteenOrders(Model model) {

        // Uses the crud repository to get all the orders and save them to the Iterable list
        Iterable<Order> orderList = orderRepository.findAll();
        // Inserts the orders from the database to a model which we pull the data from in the HTML file.
        model.addAttribute("orders", orderList);
        // Forwards the user to the HTML page canteenorders
        return "/canteenorders";
    }


}
