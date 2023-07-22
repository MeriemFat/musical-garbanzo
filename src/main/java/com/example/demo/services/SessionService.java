package com.example.demo.services;

import com.example.demo.entites.Session;
import com.example.demo.repository.SessionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SessionService implements ISession{
    @Autowired
    SessionRepo sessionRepository;

    @Override
    public Session addSession(Session S) {
        return sessionRepository.save(S);
    }

    @Override
    public List<Session> GetAllSession() {
        return sessionRepository.findAll();
    }
}
