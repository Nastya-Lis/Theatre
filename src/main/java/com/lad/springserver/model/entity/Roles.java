package com.lad.springserver.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Roles extends CommonEntity implements GrantedAuthority {
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<Users> users;
    public Roles(){

    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return  Objects.equals(name, roles.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name);
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
