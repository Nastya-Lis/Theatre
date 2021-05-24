package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/l")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapping userMapping;

    @GetMapping
    public UserDto logIn(@RequestParam String email, @RequestParam String password){
       // userService.findUserByLoginAndPassword(username,password);
       Users user =  userService.findUserByEmailAndPassword(email,password);
       return userMapping.entityToDto(user);
       // userService.findUserByAllParam(username,password,email);
    }
  //  public ResponseEntity<LoginResponse> login(@RequestBody lo)

//    @GetMapping("/greeting")
//    public String hello()
//    {
//        return "Start page";
//    }
//
//    @GetMapping("/admin")
//    public String admin()
//    {
//        return "For Admin";
//    }
//
//    @GetMapping("/userr")
//    public String user()
//    {
//        return "For User";
//    }

}
