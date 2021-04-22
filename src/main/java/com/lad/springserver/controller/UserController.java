package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.UserRepository;
import com.lad.springserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CommonController<Users, UserRepository, UserDto, UserService, UserMapping> {

    @Autowired
    public UserController(UserMapping mapper, UserService service) {
        super(mapper, service);
    }
}
