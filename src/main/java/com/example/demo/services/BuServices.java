package com.example.demo.services;

import com.example.demo.repository.BuRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuServices implements IBu {
    @Autowired
    BuRepo buRepository ;
}