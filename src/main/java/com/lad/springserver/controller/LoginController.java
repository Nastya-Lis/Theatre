package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Roles;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapping userMapping;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public UserDto logIn(@RequestParam String username, @RequestParam String password){
        Users us = (Users) userService.loadUserByUsername(username);
        Boolean bulka = bCryptPasswordEncoder.matches(password,us.getPassword());
        Users user =  userService.findUserByEmailAndPassword(username,us.getPassword());
        Roles userRole = user.getRole();
        Integer idRole = userRole.getId();

        return userMapping.entityToDto(user);
    }

    @PostMapping
    public UserDto someMethod(@RequestParam String username, @RequestParam String password) {
        Users us = (Users) userService.loadUserByUsername(username);
        Boolean bulka = bCryptPasswordEncoder.matches(password,us.getPassword());
        Users user =  userService.findUserByEmailAndPassword(username,us.getPassword());
        Roles userRole = user.getRole();
        Integer idRole = userRole.getId();
        return userMapping.entityToDto(user);
    }

}
