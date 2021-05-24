package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Users;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends IRepository<Users>{
    Users findFirstByLoginAndEmail(String login, String email);
    Users findFirstByEmail(String email);

    Users findFirstByLoginAndPassword(String login, String password);

    Users findUsersByLoginAndPasswordAndEmail(String login, String password, String Email);

    Users findUsersByEmailAndPassword(String Email, String password);
}
