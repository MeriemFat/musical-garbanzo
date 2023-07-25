package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StatuDaffectation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStat;
    private Date Nomstatutdaff;

    // liaison avec Affectation
    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "idAffectation")
    private Affectation affectation;





}
