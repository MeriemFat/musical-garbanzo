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


    @GetMapping("/getallRessources")
    List<Ressources> getAllRessources(){
        return ressourceControl.getAllRessources();
    }

    @PostMapping("/addressource/{idUser}")
    public Ressources addRessourcewithIdUser(@RequestBody Ressources r ,
                                             @PathVariable("idUser") Long idUser) {
        Ressources ressource = ressourceControl.addRessourcewithIdUser(r,idUser);
        return ressource;
    }


    @PutMapping("/update/{idRessource}")
    public void updateRessource(@RequestBody Ressources r,
                                @PathVariable("idRessource") Long idRessource ) {
        ressourceControl.updateRessource(r,idRessource);
    }


    @DeleteMapping("/removeRessource/{iduser}/{idressource}")
    public ResponseEntity<String> removeRessource(@PathVariable("idressource") Long idressource,
                             @PathVariable("iduser") Long idUser) {
        Integer test = ressourceControl.removeRessouce(idressource, idUser);
        if(test == 1)
            return ResponseEntity.ok("Resource deleted !");
        else
            return ResponseEntity.badRequest().body("only admin can delete a resource");
    }

}
