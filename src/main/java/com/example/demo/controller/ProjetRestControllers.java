package com.example.demo.controller;

import com.example.demo.entites.projet;
import com.example.demo.services.impl.ProjetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class ProjetRestControllers {
    @Autowired
    ProjetServices  projetControl;

//get all project
    //http://localhost:8082/projet/GetallProject
 @GetMapping("/GetallProject")
 List<projet> GetAllprojet() {
     return projetControl.GetAllprojet();
 }

 // add projet ( si il n'existe pas ) (check )
    // //http://localhost:8082/projet/addprojet/1
    @PostMapping("/addprojet/{idUser}/{nomprojet}")
    public ResponseEntity<String> addProjetwithIdUser(@RequestBody projet p ,
                                                      @PathVariable("idUser") Long idUser ,
                                                      @PathVariable("nomprojet") String nomprojet)
    {
        projet projets = projetControl.addProjetwithIdUser(p,idUser,nomprojet);
        if (projets != null) {
            return ResponseEntity.ok("Projet ajouté avec succès !");
        } else {
            return ResponseEntity.badRequest().body("Impossible d'ajouter le projet avec l'utilisateur fourni.");
        }
    }

    //http://localhost:8082/updateProjet/1
    @PutMapping("/updates/{idprojet}")
    public void updateProjet(@RequestBody projet p) {
        projetControl.updateProjet(p);
    }

    //http://localhost:8082/projet/removeProjet/3
    @DeleteMapping("/removeProjet/{idprojet}")
    public void removeprojet(@PathVariable("idprojet") Long idprojet) {
        projetControl.removeProjet(idprojet);
    }

}
