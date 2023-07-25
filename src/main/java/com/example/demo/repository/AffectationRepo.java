package com.example.demo.repository;

import com.example.demo.entites.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepo extends JpaRepository<Affectation, Long> {

}