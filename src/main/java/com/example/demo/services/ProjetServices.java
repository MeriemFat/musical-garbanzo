package com.example.demo.services;

import com.example.demo.entites.RoleUser;
import com.example.demo.entites.UnauthorizedActionException;
import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.projetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    public projet updateProjet(projet p,Long projectId) {
        projet existingProject = projetRepository.findById(projectId).orElseThrow(() -> new UnauthorizedActionException("Project not found with ID: " + projectId));
        BeanUtils.copyProperties(p, existingProject, "idprojet");
        return projetRepository.save(existingProject);
    }

    @Override
    public void removeProjet(Long idprojet, User currentUser){
        if(currentUser.getRoleUser() == RoleUser.admin)
            projetRepository.deleteById(idprojet);
        else
            throw new UnauthorizedActionException("Only admin users can update projects.");
    }

    @Override
    public projet addProjetwithIdUser(projet p, Long idUser ) {
        User user = userRepository.findById(idUser).orElse(null);
        p.setUser(user);
        return projetRepository.save(p);
    }

}
