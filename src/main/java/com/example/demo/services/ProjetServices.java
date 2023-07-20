package com.example.demo.services;

import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.projetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjetServices implements IProjet {
    @Autowired
    projetRepo projetRepository ;

    @Autowired
    UserRepo userRepository;
    @Override
    public List<projet> GetAllprojet() {
        return projetRepository.findAll();
    }
    @Override
    public void removeProjet(Long idprojet){projetRepository.deleteById(idprojet);}
    @Override
    public projet addProjetwithIdUser(projet p, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        p.setUser(user);
        return projetRepository.save(p);
    }

    @Override
    public projet updateEtablissement(projet p )  {
        return projetRepository.save(p);
    }


}
