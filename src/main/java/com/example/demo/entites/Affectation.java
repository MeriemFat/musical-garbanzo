package com.example.demo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Affectation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffectation;
    private String manager;
    private String departement;
    private String country;
    private String region;
    private String ressource;
    private String projet;
    private String statuDaff;
    private String natureDaff;
    private Integer joursA;
    private Integer joursB;
    private Integer joursC;



// liaison avec nature d'affectation one to many
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "affectation")
    @JsonIgnore
    @ToString.Exclude
    private List<Naturedaffectation> naturedaffectations;


    // liaison avec statu d'affectation

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "affectation")
    @JsonIgnore
    @ToString.Exclude
    private List<StatuDaffectation> statuDaffectations;


    // Many-to-one relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


    // Many-to-one relationship with Resource entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ressource")
    private Ressources resssource;


    // Many-to-one relationship with Project entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprojet")
    private projet project;


}
