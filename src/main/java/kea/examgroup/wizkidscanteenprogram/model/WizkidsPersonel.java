package kea.examgroup.wizkidscanteenprogram.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

    @Data
    @Entity
    @Table(name = "wizkidspersonel")
    public class WizkidsPersonel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String firstName;

        private String lastName;

        @NotNull
        @Past
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyy")
        private Date dob;

        @Email(message = "Email should be valid")
        private String email;

        private String password;

        @Enumerated(EnumType.STRING)
        private Gender gender;

    }


