package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Roles;
import com.lad.springserver.model.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService{
    @Autowired
    RoleRepository roleRepository;

    public Roles searchName(String name){
        return roleRepository.findFirstByName(name);
    }
}
