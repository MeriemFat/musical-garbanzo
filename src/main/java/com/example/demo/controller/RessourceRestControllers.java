package com.example.demo.controller;

import com.example.demo.entites.Ressources;
import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.services.IRessource;
import com.example.demo.services.RessourceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/Ressource")
public class RessourceRestControllers {

    @Autowired
    RessourceServices ressourceControl;


    //http://localhost:8082/Ressources/getAllRessources
    @GetMapping("/getallRessources")
    List<Ressources> getAllRessources(){
        return ressourceControl.getAllRessources();
    }



    //http://localhost:8082/Ressources/add/1
    @PostMapping("/addressource/{idUser}")
    public Ressources addRessourcewithIdUser(@RequestBody Ressources r ,
                                             @PathVariable("idUser") Long idUser) {
        Ressources ressource = ressourceControl.addRessourcewithIdUser(r,idUser);
        return ressource;
    }



    //http://localhost:8082/update-ressource/1
    @PutMapping("/update/{idRessource}")
    public void updateRessource(@RequestBody Ressources r ) {
        ressourceControl.updateRessource(r);
    }



    //http://localhost:8082/removeRessource/1
    @DeleteMapping("/removeRessource/{idressource}")
    public void removeprojet(@PathVariable("idressource") Long idressource, Principal principal) {
        User currentUser = (User) principal;
        ressourceControl.removeRessouce(idressource, currentUser);
    }

}
