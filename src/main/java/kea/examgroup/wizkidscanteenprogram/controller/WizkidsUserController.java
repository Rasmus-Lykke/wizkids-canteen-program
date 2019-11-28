package kea.examgroup.wizkidscanteenprogram.controller;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.AuthorityRepository;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/createnewuser")
    public String createUser(@Valid @RequestBody WizkidsUser wizkidsUser, Authority authority) {
        System.out.println("Running code");

        wizkidsUser.setPassword(passwordEncoder.encode(wizkidsUser.getPassword()));

        authority.setWizkidsUser(wizkidsUser.getId());
        authority.setAuthority("ROLE_ADMIN");

        wizkidsUSerRepository.save(wizkidsUser);
        authorityRepository.save(authority);

        System.out.println("Have saved");

        return "redirect:/";
    }

}
