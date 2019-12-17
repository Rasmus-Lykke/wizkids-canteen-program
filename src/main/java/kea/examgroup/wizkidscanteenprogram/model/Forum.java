package kea.examgroup.wizkidscanteenprogram.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    private String reply;

}
