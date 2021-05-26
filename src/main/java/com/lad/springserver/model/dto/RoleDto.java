package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Users;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class RoleDto extends AbstractDto{
    private String name;
}
