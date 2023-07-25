package com.example.demo.services;

import com.example.demo.entites.Affectation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAffectation {

    List<Affectation> getAllAffectations();
    Affectation addAffectation(Affectation affectation , Long idUser);

    Affectation updateAffectation(Affectation affectation);
    void deleteAffectation(Long idAffectation);
}
