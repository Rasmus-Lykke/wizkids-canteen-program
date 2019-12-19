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

@Entity
@Table(name = "authorities")
@Data
public class Authority {

    // Variable id with the auto increment and primary key annotation for the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Variable which acts as a foreign key
    @ManyToOne
    @JoinColumn(name="wizkidsuser_id")
    @NotNull
    private WizkidsUser wizkidsUser;

    // String which stores the usertype for example "ROLE_USER" or "ROLE_ADMIN"
    @NotNull
    private String authority;
}
