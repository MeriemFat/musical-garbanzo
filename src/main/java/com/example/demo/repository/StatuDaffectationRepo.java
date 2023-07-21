package com.example.demo.repository;

import com.example.demo.entites.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatuDaffectationRepo extends JpaRepository<StatuDaffectationRepo, Long> {
}
