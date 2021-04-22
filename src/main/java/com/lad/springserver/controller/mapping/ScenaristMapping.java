package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.ScenaristDto;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.entity.Scenarists;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {Performances.class})
public interface ScenaristMapping extends CommonMapping<Scenarists, ScenaristDto>{

    @Mapping( target = "performances", source = "dto.performances",qualifiedByName = "idToEntity")
    Scenarists dtoToEntity(ScenaristDto dto);
    @Mapping(target = "performances",source = "scenarist.performances",  qualifiedByName = "entitiesToId")
    ScenaristDto entityToDto(Scenarists scenarist);

    @Named("entitiesToId")
    default Set<Integer> entitiesToId(Set<Performances> performancesSet){
        return performancesSet.stream().map(CommonEntity::getId).collect(Collectors.toSet());
    }

    @Named("idToEntity")
    default Set<Performances> idToEntity(Set<Integer> setId){
        Set setPerformances = new HashSet();
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
