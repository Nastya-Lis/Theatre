package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.BookingMapping;
import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.BookingDto;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.BookingRepository;
import com.lad.springserver.model.repository.UserRepository;
import com.lad.springserver.model.service.BookingService;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/")
@Transactional
public class UserController {
    @Autowired
    UserMapping userMapping;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingMapping bookingMapping;

//ломающееся дерьмище памагити
  /*  @GetMapping(value = "/id")
    UserDto getUserById(@RequestParam Integer id){


        UserDto userDto = userMapping.entityToDto(userRepository.findById(id).get());
        return userDto;
    }*/


    /* UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
          UserDto userDto = userMapping.entityToDto(userService.findUserById(id));
          return userDto;*/

    @GetMapping("/booking/{userId}")
    public List<BookingDto> bookingUser(@PathVariable("userId") Integer userId) {
      return bookingMapping.entitiesToDtos(bookingService.getBookingsByUserId(Integer.valueOf(userId)));
    }

    @GetMapping("/{idUser}")
    public UserDto sendUserById(@PathVariable("idUser") Integer id){
        return userMapping.entityToDto(userService.findUserById(id));
    }


    @GetMapping
 //   @Secured("USER")
    UserDto getCurrentUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = userMapping.entityToDto((Users) userService.loadUserByUsername(userDetails.getUsername()));
        System.out.println("User id:" + userDto.getId());
        return userDto;
    }

}
