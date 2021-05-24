package com.lad.springserver.controller;

import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.exceptions.ShowsServiceException;
import com.lad.springserver.model.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserDto userDto, HttpServletResponse response) throws ShowsServiceException {
        userService.saveUser(userDto);
        response.setStatus(HttpStatus.CREATED.value());
    }

}
