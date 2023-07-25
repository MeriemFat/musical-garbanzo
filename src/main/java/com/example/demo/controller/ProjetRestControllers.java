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

 // add projet
    // //http://localhost:8082/projet/addProject/1
    @PostMapping("/addProject/{idUser}")
    public projet addProjetwithIdUser(@RequestBody projet p ,
                                      @PathVariable("idUser") Long idUser)
    {
        projet projets = projetControl.addProjetwithIdUser(p,idUser);
        return projets;
    }

    //http://localhost:8082/updateProjet/1
    @PutMapping("/updates/{idprojet}")
    public void updateProjet(@RequestBody projet p,
                             @PathVariable("idprojet") Long idprojet) {
        projetControl.updateProjet(p,idprojet);
    }

    //http://localhost:8082/projet/removeProjet/3
    @DeleteMapping("/removeProjet/{idprojet}")
    public void removeprojet(@PathVariable("idprojet") Long idprojet) {
        projetControl.removeProjet(idprojet);
    }

}
