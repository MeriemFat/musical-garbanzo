package com.example.demo.services;

import com.example.demo.entites.*;
import com.example.demo.repository.AffectationRepo;
import com.example.demo.repository.RessourceRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.projetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AffectationServices implements IAffectation {
    @Autowired
    AffectationRepo affectationRepository ;
    @Autowired
    UserRepo userRepository;
    @Autowired
    projetRepo projetRepository;
    @Autowired
    RessourceRepo ressourceRepository;


    @Override
    public List<Affectation> getAllAffectations(){

        return affectationRepository.findAll();
    }

    @Override
    public Affectation addAffectation (Affectation affectation , Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        projet project = projetRepository.findByNomprojet(affectation.getProjet());
        Ressources ressource = ressourceRepository.findByNomRessource(affectation.getRessource());
        affectation.setUser(user);
        affectation.setProject(project);
        affectation.setResssource(ressource);
        return affectationRepository.save(affectation );
    }

    @Override
    public Affectation updateAffectation(Affectation affectation, Long idAffectation){
        Affectation existingAffectation = affectationRepository.findById(idAffectation).orElseThrow(() -> new UnauthorizedActionException("Project not found with ID: " + idAffectation));;
        BeanUtils.copyProperties(affectation, existingAffectation,"statuDaffectations","naturedaffectations", "idAffectation");
        return affectationRepository.save(existingAffectation);
    }

    @Override
    public void deleteAffectation (Long idAffectation) {
        affectationRepository.deleteById(idAffectation);
    }
}
