package com.example.demo.services.impl;


import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserdDao;
import com.example.demo.entites.Role;
import com.example.demo.entites.User;
import com.example.demo.services.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserService implements IUser {

    @Autowired
    private UserdDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registrerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);

    }

    @Override
    public void initRolesAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);


        // User user = new User();
        //user.setUserFirstName("meriem");
        //user.setUserLastName("fat");
        //user.setUserName("meryfat");
        //user.setUserPassword(getEncodedPassword("meryfat@pass"));
        //Set<Role> userRoles = new HashSet<>();
        //userRoles.add(userRole);
        //user.setRole(userRoles);
        //userDao.save(user);


    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
