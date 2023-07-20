package com.example.demo.controller;

import com.example.demo.entites.Ressources;
import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.services.IRessource;
import com.example.demo.services.RessourceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ressource")
public class RessourceRestControllers {

    @Autowired
    RessourceServices ressourceControl;


    //get all ressources
    //http://localhost:8082/Ressources/getAllRessources
    @GetMapping("/getallRessources")
    List<Ressources> getAllRessources(){
        return ressourceControl.getAllRessources();
    }

    //add ressource (check)
    //http://localhost:8082/Ressources/add/1
    @PostMapping("/add/{idUser}")
    public Ressources addRessourcewithIdUser(@RequestBody Ressources r ,
                                             @PathVariable("idUser") Long idUser) {
        Ressources ressource = ressourceControl.addRessourcewithIdUser(r,idUser);
        return ressource;
    }

    //update ressource
    //http://localhost:8082/updateRessource/1
    @PutMapping("updateRessource/{idprojet}")
    public void updateRessource(@RequestBody Ressources r){

        ressourceControl.updateRessource(r);
    }

    //remove ressource
    //http://localhost:8082/removeRessource/1
    @DeleteMapping("/removeRessource/{idressource}")
    public void removeprojet(@PathVariable("idressource") Long idressource) {
        ressourceControl.removeRessouce(idressource);
    }

}
