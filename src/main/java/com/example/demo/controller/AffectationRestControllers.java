package com.example.demo.controller;

import com.example.demo.entites.Affectation;
import com.example.demo.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/addaffectation/{idUser}")  //check
    public Affectation addAffectation(@RequestBody Affectation Affectation,
                                      @PathVariable("idUser") Long idUser) {
        com.example.demo.entites.Affectation affectation = affectationControl.addAffectation(Affectation,idUser);
        return affectation;
    }

    @PutMapping("/update/{idAffectation}")
    public void updateAffectation(@RequestBody Affectation affectation){
        affectationControl.updateAffectation(affectation);
    }
    @DeleteMapping("/deleteaffectation/{idAffectation}")
    public void deleteAffectation(@PathVariable("idAffectation") Long idAffectation) {

        affectationControl.deleteAffectation(idAffectation);
    }
}
