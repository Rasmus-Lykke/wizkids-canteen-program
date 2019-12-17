package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Order;
import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.OrderRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


        System.out.println("Test");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Date date = new Date();

        order.setDate(date);
        order.setWizkidsUserId(wizkidsUserRepository.findUserByUsername(authentication.getName()).getId());
        order.setMenuId(menuId);
        System.out.println("Save order------------- " + menuId + " ---------  ");
        System.out.println("ID: " + order.getId());
        System.out.println("Date: " + order.getDate());
        System.out.println("User id: " + order.getWizkidsUserId());
        System.out.println("Comment: " + order.getComment());
        System.out.println("Menu id: " + order.getMenuId());
        orderRepository.save(order);

        System.out.println(orderRepository.findAll() );

        return new ModelAndView(
                new RedirectView("/personelmenu?menuordered", true));
    }


}
