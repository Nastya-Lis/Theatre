package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.PerformanceDto;
import com.lad.springserver.model.entity.Performances;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BookingMapping.class,ActorMapping.class,ScenaristMapping.class,GenreMapping.class})
public interface PerformanceMapping extends CommonMapping<Performances, PerformanceDto>{
    @Mappings({
            @Mapping(target = "bookingsById", source = "bookings"),
            @Mapping(target = "actorsSet", source = "actors"),
            @Mapping(target = "scenaristsSet", source = "scenarists"),
            @Mapping(target = "genersByGenre", source = "genre")
    })
    Performances dtoToEntity(PerformanceDto dto);

    @Mappings({
            @Mapping(target = "bookings", source = "bookingsById"),
            @Mapping(target = "actors", source = "actorsSet"),
            @Mapping(target = "scenarists", source = "scenaristsSet"),
            @Mapping(target = "genre", source = "genersByGenre")
    })

    PerformanceDto entityToDto(Performances performances);

}
