package com.example.demo.services;

import com.example.demo.entites.Ressources;
import com.example.demo.repository.RessourceRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RessourceServices implements IRessource{
    @Autowired
    RessourceRepo ressourceRepository;


    @Override
    public List<Ressources> getAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public void removeRessouces(Long idRessources) {
        ressourceRepository.deleteById(idRessources);
    }


}
