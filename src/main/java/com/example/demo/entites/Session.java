package com.example.demo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsession;
    private Date dateSession;
    private String duréeprojet ;
    @Enumerated(EnumType.STRING)
    private TypeSession typeSession ;
// liaison avec projet
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "Session")
    @JsonIgnore
    @ToString.Exclude
    private List<projet> project;

// liaison avec ressource
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "Session")
    @JsonIgnore
    @ToString.Exclude
    private List<Ressources> resources;

}
