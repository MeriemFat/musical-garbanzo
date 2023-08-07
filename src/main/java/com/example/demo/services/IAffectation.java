package com.example.demo.services;

import com.example.demo.entites.Affectation;
import com.example.demo.entites.Ressources;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAffectation {

    List<Affectation> getAllAffectations();
    List<String> addAffectation(Affectation affectation , Long idUser);

    List<String> getExceededMonths(Affectation newAffectation, Ressources resource);
    Affectation updateAffectation(Affectation affectation, Long idAffectation);
    void deleteAffectation(Long idAffectation);
}
