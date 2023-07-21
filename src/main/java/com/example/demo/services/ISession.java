package com.example.demo.services;

import com.example.demo.entites.Session;

import java.util.List;

public interface ISession {
    Session addSession(Session S);

    List<Session> GetAllSession();
}
