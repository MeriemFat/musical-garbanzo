package com.example.demo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Ressources implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRessource;
    private String nomRessource;
    private String prenomRessource;
    private String manager ;
    private String departement ;
    private int jourdispo;
    private int jourformation;
    private int jourconge;

    // liaison  with user Many to one
    @ManyToOne (fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private User user;

    // liaison avec Session
    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "idsession")
    private Session session;

}

