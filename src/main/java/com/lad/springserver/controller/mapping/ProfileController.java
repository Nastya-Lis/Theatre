package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
@Transactional
public class ProfileController {
    @Autowired
    private UserService service;
    @Autowired
    private UserMapping mapper;

    @GetMapping
    public UserDto getCurrentUser() {

        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto dto = mapper.entityToDto((Users)service.loadUserByUsername(details.getUsername()));
        return dto;
    }

}
