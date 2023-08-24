package com.example.demo.services.impl;

import com.example.demo.entites.Ressources;
import com.example.demo.entites.User;
import com.example.demo.repository.RessourceRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.IRessource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RessourceServices implements IRessource {
    @Autowired
    RessourceRepo ressourceRepository;
    @Autowired
    UserRepo userRepository;

    @Override
    public List<Ressources> getAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public void removeRessouce(Long idRessources) {
        ressourceRepository.deleteById(idRessources);
    }

    @Override
    public Ressources updateRessource(Ressources r , Long idRessources){
        Ressources existingRessource = ressourceRepository.findById(idRessources).orElseThrow(() -> new RuntimeException("Ressource not found with id: " + idRessources));
        BeanUtils.copyProperties(r, existingRessource, "idRessources");
        return ressourceRepository.save(existingRessource);
    }

    @Override
    public Ressources addRessourcewithIdUser(Ressources r, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        r.setUser(user);
        return ressourceRepository.save(r);
    }



}
