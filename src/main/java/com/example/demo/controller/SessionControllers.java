package com.example.demo.controller;
import com.example.demo.entites.Session;
import com.example.demo.services.impl.SessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    @PostMapping("/addSession/{idUser}")
    public ResponseEntity<Session>  addSession(@RequestBody Session S, @PathVariable Long idUser){
        try {
            Session addedSession = sessionControl.addSession(S, idUser);
            return new ResponseEntity<>(addedSession, HttpStatus.CREATED);
        } catch (MessagingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @PostMapping("/sendEmailing/{idUser}")
    public ResponseEntity<String> sendEmail(@RequestBody Session session, @PathVariable  Long idUser) {
        try {
            sessionControl.sendEmailSession(session, idUser);
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }
    }*/


    @SneakyThrows
    @GetMapping("/send/{idsession}")
    public ResponseEntity<String> sendEmailSession(@PathVariable("idsession") Long idsession) throws MessagingException {
        try {
            sessionControl.sendEmailSession(idsession);
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }
    }
}
