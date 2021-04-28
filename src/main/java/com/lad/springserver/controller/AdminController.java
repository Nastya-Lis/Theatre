package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//}

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

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/admin")
//    public String userList(Model model) {
//        model.addAttribute("allUsers", userService.allUsers());
//        return "admin";
//    }
//
//    @PostMapping("/admin")
//    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Integer userId,
//                              @RequestParam(required = true, defaultValue = "" ) String action,
//                              Model model) {
//        if (action.equals("delete")){
//            userService.deleteUser(userId);
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/admin/gt/{userId}")
//    public String  gtUser(@PathVariable("userId") Integer userId, Model model) {
//        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }
}

