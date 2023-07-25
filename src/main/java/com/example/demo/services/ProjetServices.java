package com.example.demo.services;

import com.example.demo.entites.RoleUser;
import com.example.demo.entites.UnauthorizedActionException;
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
    projetRepo projetRepository;

    @Autowired
    UserRepo userRepository;

    @Override
    public List<projet> GetAllprojet() {
        return projetRepository.findAll();
    }



    @Override
    public projet updateProjet(projet p, User currentUser) {
        if (currentUser.getRoleUser() == RoleUser.admin)
            return projetRepository.save(p);
        else
            throw new UnauthorizedActionException("Only admin can update projects.");
    }

    @Override
    public void removeProjet(Long idprojet, User currentUser){
        if(currentUser.getRoleUser() == RoleUser.admin)
            projetRepository.deleteById(idprojet);
        else
            throw new UnauthorizedActionException("Only admin  can update projects.");
    }


    @Override
    public projet addProjetwithIdUser(projet p, Long idUser ) {
        User user = userRepository.findById(idUser).orElse(null);
        p.setUser(user);
        return projetRepository.save(p);
    }

}
