package com.lad.springserver.controller.mapping;


import com.lad.springserver.model.dto.UserDto;

import com.lad.springserver.model.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapping extends CommonMapping<Users, UserDto>{
    @Mapping(target = "bookingsById", source = "bookings")
    Users dtoToEntity(UserDto dto);
    @Mapping(target = "bookings", source = "bookingsById")
    UserDto entityToDto(Users user);
}
