package com.example.demo.controller;

import com.example.demo.services.IRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ressource")
public class RessourceRestControllers {

    @Autowired
    IRessource ressourceControl;
}
