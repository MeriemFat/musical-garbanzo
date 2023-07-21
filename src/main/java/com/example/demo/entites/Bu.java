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


public class Bu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBu;

// liaison avec nature d'affectation one to many
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "bu")
    @JsonIgnore
    @ToString.Exclude
    private List<Naturedaffectation> naturedaffectations;


    // liaison avec statu d'affectation

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "bu")
    @JsonIgnore
    @ToString.Exclude
    private List<StatuDaffectation> statuDaffectations;



}
