package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.UserRepository;

public class UserService extends CommonServiceOperation<Users, UserRepository>{
    public UserService(UserRepository repository) {
        super(repository);
    }
}
