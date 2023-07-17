package com.example.demo.entites;
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
    private int jourdispo;
    private int jourformation;
    private int jourconge;
}

