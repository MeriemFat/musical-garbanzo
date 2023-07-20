package com.example.demo.services;
import com.example.demo.entites.projet;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IProjet {
    List<projet> GetAllprojet();

    void removeProjet(Long idprojet);

    projet addProjetwithIdUser(projet p, Long idUser);

    projet updateEtablissement(projet p);
}
