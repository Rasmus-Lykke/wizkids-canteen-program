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

@Controller
public class OrderController {

    @Autowired
    private WizkidsUserRepository wizkidsUserRepository;

    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping(value = "/createorder/{menuId}", method = RequestMethod.GET)
    public ModelAndView orderMenu(@PathVariable("menuId") @Valid @ModelAttribute long menuId, Order order) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Date date = new Date();

        order.setDate(date);
        order.setWizkidsUserId(wizkidsUserRepository.findUserByUsername(authentication.getName()).getId());
        order.setMenuId(menuId);

        orderRepository.save(order);

        return new ModelAndView(
                new RedirectView("/personelmenu?menuordered", true));
    }

    @GetMapping("/personelorders")
    public String personelOrders(Model model, Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        //order.setFirstName(wizkidsUserRepository.findById(wizkidsUserRepository.findUserByUsername(authentication.getName()).getId()).get().getFirstName());


        Iterable<Order> orderList = orderRepository.findAllByWizkidsUserId((wizkidsUserRepository.findUserByUsername(authentication.getName()).getId()));
        model.addAttribute("orders", orderList);
        return "/personelorders";
    }


}
