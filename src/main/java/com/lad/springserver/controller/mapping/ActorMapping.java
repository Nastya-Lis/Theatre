package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.ActorDto;
import com.lad.springserver.model.entity.Actors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapping extends CommonMapping<Actors, ActorDto>{
    Actors dtoToEntity(ActorDto dto);
    ActorDto entityToDto(Actors actor);
}
