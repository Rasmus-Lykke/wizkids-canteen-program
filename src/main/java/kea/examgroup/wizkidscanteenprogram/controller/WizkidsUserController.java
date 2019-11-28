package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.AuthorityRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
