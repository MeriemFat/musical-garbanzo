package com.example.demo.services;

import com.example.demo.entites.Ressources;
import com.example.demo.entites.RoleUser;
import com.example.demo.entites.UnauthorizedActionException;
import com.example.demo.entites.User;
import com.example.demo.repository.RessourceRepo;
import com.example.demo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RessourceServices implements IRessource{
    @Autowired
    RessourceRepo ressourceRepository;
    @Autowired
    UserRepo userRepository;

    @Override
    public List<Ressources> getAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public void removeRessouce(Long idRessources, User currentUser) {
        if(currentUser.getRoleUser() == RoleUser.admin)
            ressourceRepository.deleteById(idRessources);
        else
            throw new UnauthorizedActionException("Only admin can update projects.");
    }

    @Override
    public Ressources updateRessource(Ressources r ){
        return ressourceRepository.save(r);
    }

    @Override
    public Ressources addRessourcewithIdUser(Ressources r, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        r.setUser(user);
        return ressourceRepository.save(r);
    }

}
