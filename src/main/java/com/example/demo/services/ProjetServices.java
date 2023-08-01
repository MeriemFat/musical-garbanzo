package com.example.demo.services;

import com.example.demo.entites.*;
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
public class ProjetServices implements IProjet {
    @Autowired
    projetRepo projetRepository;

    @Autowired
    UserRepo userRepository;


    @Override
    public List<projet> GetAllprojet() {
        return projetRepository.findAll();
    }

    /*@Override
    public projet updateProjet(projet p,Long projectId) {
        projet existingProject = projetRepository.findById(projectId).orElseThrow(() -> new UnauthorizedActionException("Project not found with ID: " + projectId));
        BeanUtils.copyProperties(p, existingProject, "idprojet");
        return projetRepository.save(existingProject);
    }*/

    public static List<String> getProjetAttributes(Class<?> projeteClass) {
        List<String> attributeNames = new ArrayList<>();
        Field[] fields = projeteClass.getDeclaredFields();
        for (Field field : fields) {
            attributeNames.add(field.getName());
        }
        return attributeNames;
    }

    @Override
    public projet updateProjet(projet p,Long projectId) {
        projet existingProjet = projetRepository.findById(projectId).orElseThrow(() -> new UnauthorizedActionException("Project not found with ID: " + projectId));;
        List<String> attributes = getProjetAttributes(projet.class);
        Set<String> ignoreProperties = new HashSet<>();
        for (String attribute : attributes) {
            if (p.get(attribute) == null)
                ignoreProperties.add(attribute);
        }
        String[] ignorePropertiesArray = ignoreProperties.toArray(new String[0]);
        BeanUtils.copyProperties(p, existingProjet, ignorePropertiesArray);
        return projetRepository.save(existingProjet);
    }

    @Override
    public void removeProjet(Long idprojet, User currentUser){
        if(currentUser.getRoleUser() == RoleUser.admin)
            projetRepository.deleteById(idprojet);
        else
            throw new UnauthorizedActionException("Only admin users can update projects.");
    }


    @Override
    public projet addProjetwithIdUser(projet p, Long idUser , String nomprojet ) {
        User user = userRepository.findById(idUser).orElse(null);
        p.setUser(user);
        projet projetExistant = projetRepository.findByNomprojet(nomprojet);
        if (projetExistant == null) {
            projet nouveauProjet = new projet();
            nouveauProjet.setNomprojet(p.getNomprojet());
            nouveauProjet.setUser(user);
            nouveauProjet.setRegion(p.getRegion());
            nouveauProjet.setCountry(p.getCountry());
            return projetRepository.save(nouveauProjet);
        } else {
            return null;
        }
    }

}
