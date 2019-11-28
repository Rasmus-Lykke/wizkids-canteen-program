package kea.examgroup.wizkidscanteenprogram.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

    @Data
    @Entity
    @Table(name = "wizkidsuser")
    public class WizkidsUser {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String firstName;

        private String lastName;

        @NotNull
        @Past
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
        private Date dob;

        @Email(message = "Email should be valid")
        private String username;

        private String password;

        private String gender;

        private boolean enabled = true;

        @Transient
        private String role;

    }


