package com.example.demo.repository;

import com.example.demo.entites.projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projetRepo extends JpaRepository<projet, Long> {

    projet findByNomprojet(String nomProjet);
}