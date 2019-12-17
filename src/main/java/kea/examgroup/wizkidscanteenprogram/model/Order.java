package kea.examgroup.wizkidscanteenprogram.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date date;

    @JoinColumn(name="menus_id")
    private long menuId;

    @JoinColumn(name="wizkidsuser_id")
    private long wizkidsUserId;

    private String comment;

}