package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Menu;
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

/*
 * Authors: Rasmus
 *
 * The primary controller class for the menu handling.
 * From here it will be possible to create and get menus
 * both for admins but also for normal Wizkids users.
 */

@Controller
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;



    // POST mapping which saves the userinput to the database.
    @RequestMapping(value = "/createmenu", method = RequestMethod.POST)
    public ModelAndView createMenu(@Valid @ModelAttribute Menu menu) {

        // Saves the object with menu information to the database using the crud repository.
        // And prints som information to the console
        menuRepository.save(menu);
        System.out.println("Created menu: " + menu.getTitle() + ". For the date: " + menu.getDate());

        // Returns the user to the menu page
        return new ModelAndView(
                new RedirectView("/canteenmenu?menucreated", true));
    }

    // GET mapping which gets all the menus from the database.
    @GetMapping("/canteenmenu")
    public String toCanteenMenu(Model model) {

        // Uses the crud repository to get all the menus and save them to the iterable list
        Iterable<Menu> menuList = menuRepository.findAll();
        // Inserts the list to the model which we uses to pull the data in an HTML file.
        model.addAttribute("menus", menuList);

        // Forwards the user to the menu page
        return "/canteenmenu";
    }

    // GET mapping which gets all the menus from the database.
    @GetMapping("/personelmenu")
    public String toPersonelMenu(Model model) {
        // Uses the crud repository to get all the menus and save them to the iterable list
        Iterable<Menu> menuList = menuRepository.findAll();
        // Inserts the list to the model which we uses to pull the data in an HTML file.
        model.addAttribute("menus", menuList);
        // Forwards the user to the menu page
        return "/personelmenu";
    }

}
