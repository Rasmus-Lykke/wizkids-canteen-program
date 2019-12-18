package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Forum;
import kea.examgroup.wizkidscanteenprogram.repository.ForumRepository;
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
 * The primary controller class for the forum handling.
 * From here it will be possible to create and get questions and answers '
 * both for admins but also for normal Wizkids users and eventually answer questions as admin.
 */

@Controller
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;


    // GET mapping which gets all the questions and answers from the forum table
    @GetMapping("/persoenlforum")
    public ModelAndView toPersonelForum(Model model) {
        // Uses the crud repository to get all the questions and answers and save the to the Iterable list
        Iterable<Forum> forumList = forumRepository.findAll();
        // Insterts the data in a model which we use to pull the information in a HTML file.
        model.addAttribute("forums", forumList);

        // Forwards the user to personelforum.
        return new ModelAndView(
                new RedirectView("/personelforum", true));
    }

    // POST mapping which saves the userinput as a new question in the database.
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView createQuestion(@Valid @ModelAttribute Forum forum) {

        // Uses the crud repository to save the object to the database.
        forumRepository.save(forum);

        // Returns the user to the forum page
        return new ModelAndView(
                new RedirectView("/personelforum", true));
    }

}
