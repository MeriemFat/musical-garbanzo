package com.example.demo.controller;

import com.example.demo.services.IProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projet")
public class ProjetRestControllers {
    @Autowired
    IProjet projetControl;

}
