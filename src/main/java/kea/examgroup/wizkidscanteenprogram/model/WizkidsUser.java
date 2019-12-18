package kea.examgroup.wizkidscanteenprogram.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;


/*
 * Authors: Rasmus
 *
 * The primary model class for the User.
 * This class uses the spring annotations, to create a database table
 *  and automatic getters and setters for the class.
 */

    @Data
    @Entity
    @Table(name = "wizkidsusers")
    public class WizkidsUser {

        // Variable id with the auto increment and primary key annotation for the database.
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        // Variable which stores the first name
        private String firstName;

        // Variable which stores the last name
        private String lastName;

        //Variable which stores the date of birth. Spring annotations which validates that the date is in the past
        // and uses Json to format the date
        @NotNull
        @Past
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
        private Date dateOfBirth;

        // Variable which stores the email. The Spring annotation makes sure that the string includes "@"
        // followed by at least one more character
        @Email(message = "Email should be valid")
        private String username;

        // String variable which stores the password
        private String password;

        // String variable which stores the gender
        private String gender;

        // Boolean which must be set to true for the user to be able to login
        private boolean enabled = true;

        // Variable which stores the role of the user. The transient annotation makes sure the variable
        // wont be saved in the database but only as a java variable.
        // Might be unnessesary
        @Transient
        private String role;

        // Variable which stores the id of the user. The transient annotation makes sure the variable
        // wont be saved in the database but only as a java variable
        // Might be unnessesary
        @Transient
        private long wizkidsUserId;
    }


