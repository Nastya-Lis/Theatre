package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.GenreDto;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.entity.Performances;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PerformanceMapping.class})
public interface GenreMapping extends CommonMapping<Geners, GenreDto>{
    @Mapping(target = "performancesById", source = "performancesId", qualifiedByName = "idToEntity")
    Geners dtoToEntity(GenreDto dto);
    @Mapping(target = "performancesId", source = "performancesById", qualifiedByName = "entityToId")
    GenreDto entityToDto(Geners actor);

   /* @Named("entityToId")
    default Integer entityToId(Performances performance){
        return performance.getId();
    }

   */
    @Named("entityToId")
    default Collection<Integer> entityToId(Collection<Performances> performances){
        return performances.stream().map(CommonEntity::getId).collect(Collectors.toList());
    }

    @Named("idToEntity")
    default Collection<Performances> idToEntity(Collection<Integer> idCollection){
        /*if(id == null)
            return null;*/
        //ArrayList<Integer> ids = (ArrayList<Integer>) idCollection;


        Collection<Performances> performancesCollection = new ArrayList<>();

        for (Integer id: idCollection) {
            if(id != null){
                Performances performances = new Performances();
                performances.setId(id);
                performancesCollection.add(performances);
            }
        }

        return performancesCollection;
       /*        performances.setId(id);
        return performances;*/
    }

}
