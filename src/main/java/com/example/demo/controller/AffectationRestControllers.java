package com.example.demo.controller;

import com.example.demo.entites.Affectation;
import com.example.demo.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affectation")
public class AffectationRestControllers {
    @Autowired
    AffectationServices affectationControl;

    @GetMapping("/getallaffectations")  //check
    public List<Affectation> getAllaffectations() {
        return affectationControl.getAllAffectations();
    }




    @PostMapping("/addaffectation/{idUser}")
    public ResponseEntity<String> addAffectation(@RequestBody Affectation Affectation,
                                                 @PathVariable("idUser") Long idUser) {
        List<String> affectation = affectationControl.addAffectation(Affectation,idUser);
        if(affectation == null)
            return ResponseEntity.badRequest().body("une affectation avec le meme projet et meme ressource existe déjà");
        else if(affectation.isEmpty())
            return ResponseEntity.ok("affectation ajouté avec succès !");
        else
        return ResponseEntity.badRequest().body("vous avez depassé les nombre de jours de travail de ces mois" + affectation);
    }





    @PutMapping("/update/{idAffectation}")
    public void updateAffectation(@RequestBody Affectation affectation,
                                  @PathVariable("idAffectation") Long idAffectation){
        affectationControl.updateAffectation(affectation, idAffectation);
    }




    @DeleteMapping("/deleteaffectation/{idAffectation}")
    public void deleteAffectation(@PathVariable("idAffectation") Long idAffectation) {

        affectationControl.deleteAffectation(idAffectation);
    }
}
