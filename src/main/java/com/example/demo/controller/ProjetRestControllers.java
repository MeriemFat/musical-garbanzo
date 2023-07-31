package com.example.demo.controller;

import com.example.demo.entites.User;
import com.example.demo.entites.projet;
import com.example.demo.services.IProjet;
import com.example.demo.services.ProjetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    /*@PostMapping("/addProject/{idUser}")
    public projet addProjetwithIdUser(@RequestBody projet p ,
                                      @PathVariable("idUser") Long idUser)
    {
        projet projets = projetControl.addProjetwithIdUser(p,idUser);
        return projets;
    }*/

    @PostMapping("/addprojet/{idUser}/{nomprojet}")
    public ResponseEntity<String> addProjetwithIdUser(@RequestBody projet p ,
                                                      @PathVariable("idUser") Long idUser ,
                                                      @PathVariable("nomprojet") String nomprojet) {
        projet projets = projetControl.addProjetwithIdUser(p, idUser, nomprojet);
        if (projets != null)
            return ResponseEntity.ok("Projet ajouté avec succès !");
        else
            return ResponseEntity.badRequest().body("Impossible d'ajouter le projet avec l'utilisateur fourni.");
    }



    //http://localhost:8082/updateProjet/1
    @PutMapping("/updates/{idprojet}")
    public void updateProjet(@RequestBody projet p,
                             @PathVariable("idprojet") Long idprojet) {
        projetControl.updateProjet(p,idprojet);
    }




    //http://localhost:8082/projet/removeProjet/3
    @DeleteMapping("/removeProjet/{iduser}/{idprojet}")
    public void removeprojet(@PathVariable("idprojet") Long idprojet,
                             @PathVariable("iduser") User currentUser) {
        projetControl.removeProjet(idprojet, currentUser);
    }

}
