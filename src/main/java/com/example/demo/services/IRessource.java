package com.example.demo.services;

import com.example.demo.entites.Ressources;
import com.example.demo.entites.projet;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface IRessource {

    List<Ressources> getAllRessources();

    void removeRessouces(Long idRessources);



}
