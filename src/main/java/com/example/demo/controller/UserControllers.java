package com.example.demo.controller;
import com.example.demo.entites.User;
import com.example.demo.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping({"/RoleAndUser"})

    public void initRoleAndUser() {
        userService.initRolesAndUser();
    }


    @PostMapping({"/registerNewUser"})
    public User registrerNewUser(@RequestBody User user) {
        return userService.registrerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "this is for Admin";
    }


    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "this is for User";

    }

}
