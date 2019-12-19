package kea.examgroup.wizkidscanteenprogram.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 * Authors: Rasmus
 *
 * The primary model class for the Authority.
 * This class uses the spring annotations, to create a database table
 *  and automatic getters and setters for the class.
 */

@Data
@Entity
@Table(name = "forum")
public class Forum {

    // Variable id with the auto increment and primary key annotation for the database.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // String variable which stores the title of the question
    @NotNull
    private String title;

    // String variable which stores the Wizkids user question
    @NotNull
    private String question;

    // String variable which store the canteen employees answer to the question
    private String reply;

}
