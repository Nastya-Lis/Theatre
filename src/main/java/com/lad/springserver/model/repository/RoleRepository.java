package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Roles;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends IRepository<Roles>{
   /* @Query("SELECT * FROM Roles WHERE ")
    Optional<Roles> findRolesByName(String name);*/

    Roles findFirstByName(String name);
}
