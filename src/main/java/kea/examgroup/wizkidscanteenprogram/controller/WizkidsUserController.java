package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.AuthorityRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@RestController
public class WizkidsUserController {

    @Autowired
    private WizkidsUserRepository wizkidsUSerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid @ModelAttribute WizkidsUser wizkidsUser) {
        Authority authority = new Authority();

        wizkidsUser.setPassword(passwordEncoder.encode(wizkidsUser.getPassword()));

        authority.setWizkidsUser(wizkidsUser);
        authority.setAuthority(wizkidsUser.getRole());

        wizkidsUSerRepository.save(wizkidsUser);
        authorityRepository.save(authority);

        return new ModelAndView(
                new RedirectView("/login?usercreated", true));
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ModelAndView checkUserType(HttpServletRequest request) {

        if(request.isUserInRole("ROLE_USER")){
            System.out.println("Logged in as: USER");
            return new ModelAndView(
                    new RedirectView("/personelmenu", true));

        } else if(request.isUserInRole("ROLE_ADMIN")) {
            System.out.println("Logged in as: ADMIN");
            return new ModelAndView(
                    new RedirectView("/canteenmenu", true));

        } else {
            return new ModelAndView(
                    new RedirectView("/login", true));
        }

    }
}
