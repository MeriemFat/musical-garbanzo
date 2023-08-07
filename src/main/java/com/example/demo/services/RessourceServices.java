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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
    public Integer removeRessouce(Long idRessources, Long idUser) {
        User currentUser = userRepository.findById(idUser).orElse(null);
        if(currentUser.getRoleUser() == RoleUser.admin){
            ressourceRepository.deleteById(idRessources);
        return 1;
        }
        else
                return 0;
    }

    public static List<String> getResourceAttributes(Class<?> resourceClass) {
        List<String> attributeNames = new ArrayList<>();
        Field[] fields = resourceClass.getDeclaredFields();
        for (Field field : fields) {
            attributeNames.add(field.getName());
        }
        return attributeNames;
    }

    @Override
    public Ressources updateRessource(Ressources r, Long idRessource) {
        Ressources existingRessource = ressourceRepository.findById(idRessource).orElseThrow(() -> new UnauthorizedActionException("Ressource not found with ID: " + idRessource));;
        List<String> attributes = getResourceAttributes(Ressources.class);
        Set<String> ignoreProperties = new HashSet<>();
        for (String attribute : attributes) {
            if (r.get(attribute) == null)
                ignoreProperties.add(attribute);
        }
        String[] ignorePropertiesArray = ignoreProperties.toArray(new String[0]);
        BeanUtils.copyProperties(r, existingRessource, ignorePropertiesArray);
        return ressourceRepository.save(existingRessource);
    }

    @Override
    public Ressources addRessourcewithIdUser(Ressources r, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        r.setUser(user);
        return ressourceRepository.save(r);
    }

}
