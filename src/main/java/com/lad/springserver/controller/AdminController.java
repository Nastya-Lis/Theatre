package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapping mapper;

    @GetMapping
    public List<UserDto> userList() {
        return mapper.entitiesToDtos(userService.allUsers());
    }

    @GetMapping("/grant/{userId}")
    public void confirmUser(@PathVariable("userId") Integer userId) {
        userService.increaseUserToAdmin(userId);
    }
    @GetMapping("/revoke/{userId}")
    public void revokeUser(@PathVariable("userId") Integer userId) {
        userService.downGradeToUser(userId);
    }
}

