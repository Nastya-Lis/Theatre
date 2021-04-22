package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommonServiceOperation<Users, UserRepository>{
    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }
}
