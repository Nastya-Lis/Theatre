package com.lad.springserver.model.service;

import com.lad.springserver.controller.mapping.UserMapping;
import com.lad.springserver.model.dto.UserDto;
import com.lad.springserver.model.entity.Roles;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.exceptions.ShowsServiceException;
import com.lad.springserver.model.repository.RoleRepository;
import com.lad.springserver.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapping userMapping;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findFirstByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("There is no such user");
        }
        return user;
    }

    public Users findUserByLoginAndPassword(String login, String password) throws UsernameNotFoundException{
        Users user = userRepository.findFirstByLoginAndPassword(login,password);
        if(user == null){
            throw new UsernameNotFoundException("There is no such user");
        }
        return user;
    }

    public Users findUserById(Integer userId) {
        Optional<Users> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Users());
    }

    public Users findUserByAllParam(String login, String password, String email){
        return userRepository.findUsersByLoginAndPasswordAndEmail(login,password,email);
    }

    public Users findUserByEmailAndPassword( String email,String password){
        return userRepository.findUsersByEmailAndPassword(email,password);
    }


    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserDto userDto) throws ShowsServiceException {

//        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
//            throw new DeliveryServiceException("Passwords not equals");
//        }

        userDto.setRoleId(2);
        Users user = userMapping.dtoToEntity(userDto);
        Users userFromDB = userRepository.findFirstByEmail(user.getUsername());

        if (userFromDB != null) {
            throw new ShowsServiceException("User already exists");
        }

        Users newUsersForCreatingId = new Users();
        newUsersForCreatingId.setLogin(user.getLogin());
        newUsersForCreatingId.setEmail(user.getEmail());

        newUsersForCreatingId.setRole(/*Collections.singleton(*/roleRepository.findFirstByName("ROLE_USER"));
        newUsersForCreatingId.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(newUsersForCreatingId);

       /* Users userFromDB = userRepository.findFirstByEmail(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRole(*//*Collections.singleton(*//*new Roles(3, "ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;*/
    }


    public void increaseUserToAdmin(Integer id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setRole(roleRepository.findFirstByName("ROLE_ADMIN"));
            userRepository.save(user);
        });
    }
    public void downGradeToUser(Integer id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setRole(roleRepository.findFirstByName("ROLE_USER"));
            userRepository.save(user);
        });
    }

    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Users> usergtList(Integer idMin) {
        return em.createQuery("SELECT u FROM Users u WHERE u.id > :paramId", Users.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
