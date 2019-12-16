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

@Controller
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;


    @GetMapping("/persoenlforum")
    public ModelAndView personelForum(Model model) {
        Iterable<Forum> forumList = forumRepository.findAll();
        model.addAttribute("forums", forumList);
        return new ModelAndView(
                new RedirectView("/personelforum", true));
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView createQuestion(@Valid @ModelAttribute Forum forum) {

        forumRepository.save(forum);

        return new ModelAndView(
                new RedirectView("/personelforum", true));
    }

}
