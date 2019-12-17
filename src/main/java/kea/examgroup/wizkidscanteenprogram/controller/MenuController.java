package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Menu;
import kea.examgroup.wizkidscanteenprogram.model.Order;
import kea.examgroup.wizkidscanteenprogram.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;


    @RequestMapping(value = "/createmenu", method = RequestMethod.POST)
    public ModelAndView createMenu(@Valid @ModelAttribute Menu menu) {

        menuRepository.save(menu);
        System.out.println("Created menu: " + menu.getTitle() + ". For the date: " + menu.getDate());

        return new ModelAndView(
                new RedirectView("/canteenmenu?menucreated", true));
    }

    @GetMapping("/canteenmenu")
    public String toCanteenMenu(Model model) {
        Iterable<Menu> menuList = menuRepository.findAll();
        model.addAttribute("menus", menuList);
        return "/canteenmenu";
    }

    @GetMapping("/personelmenu")
    public String toPersonelMenu(Model model) {
        Iterable<Menu> menuList = menuRepository.findAll();
        model.addAttribute("menus", menuList);
        return "/personelmenu";
    }

}
