package kea.examgroup.wizkidscanteenprogram.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
 * Authors: Rasmus
 *
 * The primary model class for the Order.
 * This class uses the spring annotations, to create a database table
 *  and automatic getters and setters for the class.
 */

@Data
@Entity
@Table(name = "orders")
public class Order {

    // Variable id with the auto increment and primary key annotation for the database.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Variable which stores the date
    @NotNull
    private Date date;

    // Long variable which works as a foreign key
    @JoinColumn(name="menus_id")
    private long menuId;

    // Long variable which works as a foreign key
    @JoinColumn(name="wizkidsuser_id")
    private long wizkidsUserId;

    // Variable which store comments to the order
    private String comment;

    // Variable which stores the first name of the user. The transient annotation makes sure the variable
    // wont be saved in the database but only as a java variable
    @Transient
    private String firstName;
}