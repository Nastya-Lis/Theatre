package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.ActorDto;
import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.entity.Performances;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = {PerformanceMapping.class})
public interface ActorMapping extends CommonMapping<Actors, ActorDto>{

    @Mapping(target = "performances", source = "dto.performances", qualifiedByName = "idToEntity")
    Actors dtoToEntity(ActorDto dto);

    @Mapping(target = "performances", source = "actor.performances", qualifiedByName = "entitiesToId")
    ActorDto entityToDto(Actors actor);

    @Named("entitiesToId")
    default Set<Integer> entitiesToId(Set<Performances> performancesSet){
        return performancesSet.stream().map(CommonEntity::getId).collect(Collectors.toSet());
    }

    @Named("idToEntity")
    default Set<Performances> idToEntity(Set<Integer> setId){

        Set<Performances> setPerformances = new HashSet<>();

        for (Integer id: setId) {
            if(id!=null){
                Performances performance= new Performances();
                performance.setId(id);
                setPerformances.add(performance);
            }
        }

        return setPerformances;
    }

}
