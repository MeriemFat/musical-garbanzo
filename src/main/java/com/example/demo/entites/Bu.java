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


// liaison with Nature d'affectation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "BU")
    @JsonIgnore
    @ToString.Exclude
    private List<Naturedaffectation> naturedaffectations;

    // liaison with statu d'affectation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "BU")
    @JsonIgnore
    @ToString.Exclude
    private List<StatuDaffectation> statuDaffectations ;


}
