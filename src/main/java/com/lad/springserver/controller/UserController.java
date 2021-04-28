package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.UserRepository;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/profile")
@Transactional
public class UserController {
    @Autowired
    UserMapping userMapping;

    @Autowired
    UserService userService;

    @GetMapping
    UserDto getCurrentUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = userMapping.entityToDto((Users) userService.loadUserByUsername(userDetails.getUsername()));
        return userDto;
    }

}
