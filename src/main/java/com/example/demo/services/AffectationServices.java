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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<String> getExceededMonths(Affectation newAffectation, Ressources r) {
        List<Affectation> existingAffectations =  affectationRepository.findByNomRessourceAndPrenomRessource(r.getNomRessource(), r.getPrenomRessource());

        int sumMoisA = existingAffectations.stream().mapToInt(Affectation::getMoisA).sum();
        int sumMoisB = existingAffectations.stream().mapToInt(Affectation::getMoisB).sum();
        int sumMoisC = existingAffectations.stream().mapToInt(Affectation::getMoisC).sum();

        int newSumMoisA = sumMoisA + newAffectation.getMoisA();
        int newSumMoisB = sumMoisB + newAffectation.getMoisB();
        int newSumMoisC = sumMoisC + newAffectation.getMoisC();

        int moisALimit = 19; // Your specific value here
        int moisBLimit = 16;
        int moisCLimit = 18;

        List<String> exceededMonths = new ArrayList<>();
        if (newSumMoisA > moisALimit)
            exceededMonths.add("moisA");
        if (newSumMoisB > moisBLimit)
            exceededMonths.add("moisB");
        if (newSumMoisC > moisCLimit)
            exceededMonths.add("moisC");

        return exceededMonths;
    }



    @Override
    public List<String> addAffectation (Affectation affectation , Long idUser) {
        Ressources r = ressourceRepository.findByNomRessourceAndPrenomRessource(affectation.getNomRessource(), affectation.getPrenomRessource()) ;
        Affectation f = affectationRepository.findByProjetAndResssource(affectation.getProjet(), r);
        if(f != null){
            return null;
        }
        List<String> exceededMonths = getExceededMonths(affectation, r);
        if(exceededMonths.isEmpty()) {
            User user = userRepository.findById(idUser).orElse(null);
            projet project = projetRepository.findByNomprojet(affectation.getProjet());
            affectation.setUser(user);
            affectation.setProject(project);
            affectation.setResssource(r);
            affectation.setSommeParProjet(affectation.getMoisA() + affectation.getMoisB() + affectation.getMoisC());
            affectationRepository.save(affectation);
        }
            return exceededMonths;
    }




    public static List<String> getAffectationAttributes(Class<?> affectationClass) {
        List<String> attributeNames = new ArrayList<>();
        Field[] fields = affectationClass.getDeclaredFields();
        for (Field field : fields) {
            attributeNames.add(field.getName());
        }
        return attributeNames;
    }

    @Override
    public Affectation updateAffectation(Affectation affectation, Long idAffectation){
        Affectation existingAffectation = affectationRepository.findById(idAffectation).orElseThrow(() -> new UnauthorizedActionException("Affectation not found with ID: " + idAffectation));;
        List<String> attributes = getAffectationAttributes(Affectation.class);
        Set<String> ignoreProperties = new HashSet<>();
        for (String attribute : attributes) {
            if (affectation.get(attribute) == null)
                ignoreProperties.add(attribute);
        }
        String[] ignorePropertiesArray = ignoreProperties.toArray(new String[0]);
        BeanUtils.copyProperties(affectation, existingAffectation,ignorePropertiesArray);
        existingAffectation.setSommeParProjet(affectation.getMoisA()+ affectation.getMoisB()+ affectation.getMoisC());
        existingAffectation.setProject(projetRepository.findByNomprojet(affectation.getProjet()));
        existingAffectation.setResssource(ressourceRepository.findByNomRessourceAndPrenomRessource(affectation.getNomRessource(), affectation.getPrenomRessource()));
        return affectationRepository.save(existingAffectation);
    }

    @Override
    public void deleteAffectation (Long idAffectation) {
        affectationRepository.deleteById(idAffectation);
    }
/*
    public List<Affectation> getAffectationsByResource(Ressources resource) {
        return (List<Affectation>) affectationRepository.findByResssource(resource);
    }*/
}
