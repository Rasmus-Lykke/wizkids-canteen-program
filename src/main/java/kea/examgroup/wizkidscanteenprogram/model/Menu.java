package kea.examgroup.wizkidscanteenprogram.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
 * Authors: Rasmus
 *
 * The primary model class for the Menu.
 * This class uses the spring annotations, to create a database table
 *  and automatic getters and setters for the class.
 */

@Data
@Entity
@Table(name = "menus")
public class Menu {

    // Variable id with the auto increment and primary key annotation for the database.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Variable which stores the title of the menu
    @NotNull
    private String title;

    // Variable which stores the description of the menu
    @NotNull
    private String description;

    //Variable which stores the date for the menu. Spring annotations which validates that the date is in the future
    // and uses Json to format the date
    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date date;

}


