package com.lad.springserver.controller.mapping;
import com.lad.springserver.model.dto.UserDto;

import com.lad.springserver.model.entity.Roles;
import com.lad.springserver.model.entity.Users;
import com.lad.springserver.model.repository.RoleRepository;
import com.lad.springserver.model.service.RoleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;


@Mapper(componentModel = "spring",uses = {BookingMapping.class,RoleMapping.class})
public interface UserMapping extends CommonMapping<Users, UserDto>{

    @Mappings({
            @Mapping(target = "bookingsById", source = "bookings"),
            @Mapping(target = "role", source = "roleId",qualifiedByName = "nameToEntity")
    })
    Users dtoToEntity(UserDto dto);

    @Mappings({
            @Mapping(target = "bookings", source = "bookingsById"),
            @Mapping(target = "roleId", source = "role", qualifiedByName = "entityToName")
    })

    UserDto entityToDto(Users user);

    @Named("nameToEntity")
    default Roles nameToEntity(String name){
        RoleService roleService = new RoleService();
        return roleService.searchName(name);
    }


    @Named("entityToName")
    default String entityToName(Roles role){
        return role.getName();
    }

}
