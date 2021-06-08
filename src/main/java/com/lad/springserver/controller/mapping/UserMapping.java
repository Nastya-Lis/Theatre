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

import javax.persistence.criteria.CriteriaBuilder;


@Mapper(componentModel = "spring",uses = {BookingMapping.class,RoleMapping.class})
public interface UserMapping extends CommonMapping<Users, UserDto>{

    @Mappings({
            @Mapping(target = "bookingsById", source = "bookings"),
            @Mapping(target = "role", source = "roleId",qualifiedByName = "idToEntity")
    })
    Users dtoToEntity(UserDto dto);

    @Mappings({
            @Mapping(target = "bookings", source = "bookingsById"),
            @Mapping(target = "roleId", source = "role", qualifiedByName = "entityToId")
    })

    UserDto entityToDto(Users user);

    @Named("idToEntity")
    default Roles idToEntity(Integer id){
        Roles role = new Roles();
        role.setId(id);
        return role;
    }

    @Named("entityToId")
    default Integer entityToId(Roles role){
        return role.getId();
    }

}
