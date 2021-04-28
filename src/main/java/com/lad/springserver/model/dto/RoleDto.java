package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Users;

import javax.persistence.OneToMany;
import java.util.Set;

public class RoleDto extends AbstractDto{
    private String name;
}
