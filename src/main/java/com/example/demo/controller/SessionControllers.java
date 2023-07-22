package com.example.demo.controller;
import com.example.demo.entites.Session;
import com.example.demo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Session")
public class SessionControllers {

    @Autowired
    SessionService sessionControl ;

    // http://localhost:8082/Session/GetallSession
    @GetMapping("/GetallSession")
    List<Session> GetAllSession() {
        return sessionControl.GetAllSession();
    }


    // http://localhost:8082/Session/addsession
    @PostMapping("/addaddsession")
    public Session addSession(@RequestBody Session S )
    {
        Session session = sessionControl.addSession(S);
        return session;
    }

}
