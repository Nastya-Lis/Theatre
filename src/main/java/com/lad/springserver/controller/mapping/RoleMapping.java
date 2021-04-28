package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.RoleDto;
import com.lad.springserver.model.entity.Roles;
import org.mapstruct.Mapper;


@Mapper(componentModel = "string")
public interface RoleMapping extends CommonMapping<Roles, RoleDto>{
    Roles dtoToEntity(RoleDto dto);
    RoleDto entityToDto(Roles role);
}
