package com.example.demo.services.impl;

import com.example.demo.entites.Session;
import com.example.demo.entites.TypeSession;
import com.example.demo.entites.User;
import com.example.demo.repository.SessionRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.ISession;
import com.example.demo.utils.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class SessionService implements ISession {
    @Autowired
    SessionRepo sessionRepository;
    @Autowired
    UserRepo userRepository;
    @Autowired
    private MailService mailService;

    @Override
    @Transactional
    public Session addSession(Session S, Long idUser)  throws MessagingException {
        User user = userRepository.findById(idUser).orElse(null);
        S.setUser(user);
        return sessionRepository.save(S);
    }
@Override
    public void sendEmailSession(Long idsession ) throws MessagingException {
    Session session = sessionRepository.findById(idsession).orElse(null);
       // User user = userRepository.findById(idUser).orElse(null);
      //  if (user == null) {
            // log.warn("User not found for id: " + idUser);
          //  return;
        //}
        if ("Active".equals(session.getTypeSession())) {
            log.info("Votre Session est ouverte du : " + session.getDateDebutSession() + " et se fermera le " + session.getDateFinSession());
            mailService.sendActiveSession(session.getEmail(), TypeSession.Active, session.getDateDebutSession(), session.getDateFinSession());
        }
    }

    @Override
    public List<Session> GetAllSession() {
        return sessionRepository.findAll();
    }

}
