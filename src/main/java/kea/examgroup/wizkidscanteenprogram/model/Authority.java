package kea.examgroup.wizkidscanteenprogram.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Data
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="wizkidsuser_id")
    private WizkidsUser wizkidsUser;

    private String authority;
}
