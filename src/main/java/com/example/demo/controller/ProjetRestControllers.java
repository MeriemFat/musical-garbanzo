package com.example.demo.controller;

import com.example.demo.entites.User;
import com.example.demo.entites.projet;
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

         @GetMapping("/GetallProject")
         List<projet> GetAllprojet() {
             return projetControl.GetAllprojet();
         }


        @PostMapping("/addprojet/{idUser}")
        public ResponseEntity<String> addProjetwithIdUser(@RequestBody projet p ,
                                                          @PathVariable("idUser") Long idUser
                                                          ) {
            projet projets = projetControl.addProjetwithIdUser(p, idUser);
            if (projets != null) {
                return ResponseEntity.ok("Projet ajouté avec succès !");
            } else {
                return ResponseEntity.badRequest().body("Projet existe déjà");
            }
        }

    //http://localhost:8082/updateProjet/1
    @PutMapping("/updates/{idprojet}")
    public void updateProjet(@RequestBody projet p,
                             @PathVariable("idprojet") Long idprojet) {
        projetControl.updateProjet(p,idprojet);
    }


    @DeleteMapping("/removeProjet/{iduser}/{idprojet}")
    public ResponseEntity<String> removeprojet(@PathVariable("idprojet") Long idprojet,
                             @PathVariable("iduser") Long idUser) {
        Integer test = projetControl.removeProjet(idprojet, idUser);
        if(test == 1)
            return ResponseEntity.ok("Project deleted !");
     else
        return ResponseEntity.badRequest().body("only admin can delete a project");

    }

}
