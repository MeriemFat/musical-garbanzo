package com.example.demo.controller;

import com.example.demo.services.IBu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Bu")
public class BuRestControllers {
    @Autowired
    IBu buControl;
}
