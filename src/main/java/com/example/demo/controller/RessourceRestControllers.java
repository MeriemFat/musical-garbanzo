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

    //add ressource
    //http://localhost:8082/Ressources/add/1
    @PostMapping("/addressource/{idUser}")
    public Ressources addRessourcewithIdUser(@RequestBody Ressources r ,
                                             @PathVariable("idUser") Long idUser) {
        Ressources ressource = ressourceControl.addRessourcewithIdUser(r,idUser);
        return ressource;
    }

    //update ressource ( chek)
    //http://localhost:8082/update-ressource/1
    @PutMapping("update/{{idRessource}}")
    public ResponseEntity<Ressources> updateRessource(@RequestBody Ressources r , @PathVariable("Long idRessources") Long idressource){
        Ressources updatedEntity = ressourceControl.updateRessource(r, idressource);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    //remove ressource
    //http://localhost:8082/removeRessource/1
    @DeleteMapping("/removeRessource/{idressource}")
    public void removeprojet(@PathVariable("idressource") Long idressource) {
        ressourceControl.removeRessouce(idressource);
    }

}
