package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.AuthorityRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/*
 * Authors: Rasmus
 *
 * The primary controller class for the user handling.
 * From here it will be possible to create a new user
 * and gets redirected to a correct page after a successful login
 * based on the users user type.
 */

@RestController
public class WizkidsUserController {

    @Autowired
    private WizkidsUserRepository wizkidsUserRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // POST mapping which uses the userinput to save a new user to the database.
    @RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid @ModelAttribute WizkidsUser wizkidsUser) {
        // Initiate an object of the authority class.
        Authority authority = new Authority();

        // Encrypts the users password and saves the encrypted password to the object.
        wizkidsUser.setPassword(passwordEncoder.encode(wizkidsUser.getPassword()));

        // Saves user information to the authority object.
        authority.setWizkidsUser(wizkidsUser);
        authority.setAuthority(wizkidsUser.getRole());

        // Uses the crud repository to save the user object and authority object to the database
        wizkidsUserRepository.save(wizkidsUser);
        authorityRepository.save(authority);

        // Returns the user to the loginpage
        return new ModelAndView(
                new RedirectView("/login?usercreated", true));
    }

    // GET mapping which redirects the user to a main page based on their user type
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
