package com.example.demo.services;

import com.example.demo.repository.projetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProjetServices implements IProjet {
    @Autowired
    projetRepo projetRepository ;




}
