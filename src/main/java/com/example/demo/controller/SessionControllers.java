package com.example.demo.controller;

import com.example.demo.entites.Session;
import com.example.demo.entites.projet;
import com.example.demo.services.ProjetServices;
import com.example.demo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Session")
public class SessionControllers {

    @Autowired
    SessionService sessionControl ;

    @GetMapping("/GetallSession")
    List<Session> GetAllSession() {
        return sessionControl.GetAllSession();
    }





}
