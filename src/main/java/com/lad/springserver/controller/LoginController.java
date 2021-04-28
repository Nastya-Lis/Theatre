package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapping userMapping;


    @GetMapping
    public void logIn(@RequestParam String username, @RequestParam String password){
        userService.findUserByLoginAndPassword(username,password);
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
