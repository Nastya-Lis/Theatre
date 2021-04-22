package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.PerformanceDto;
import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.entity.Performances;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {BookingMapping.class,ActorMapping.class,ScenaristMapping.class,GenreMapping.class})
public interface PerformanceMapping extends CommonMapping<Performances, PerformanceDto>{
    @Mappings({
            @Mapping(target = "bookingsById", source = "bookings", qualifiedByName = "idToEBooking"),
            @Mapping(target = "actorsSet", source = "actors"/*, qualifiedByName = "idToEActor"*/),
            @Mapping(target = "scenaristsSet", source = "scenarists"),
            @Mapping(target = "genersByGenre", source = "genre")
    })
    Performances dtoToEntity(PerformanceDto dto);


    @Mappings({
            @Mapping(target = "bookings", source = "bookingsById" , qualifiedByName = "eToIdBooking"),
            @Mapping(target = "actors", source = "actorsSet"/*, qualifiedByName = "eToIdActor"*/),
            @Mapping(target = "scenarists", source = "scenaristsSet"),
            @Mapping(target = "genre", source = "genersByGenre")
    })
    PerformanceDto entityToDto(Performances performances);


    @Named("idToEBooking")
    default Collection<Booking> idToEBooking(Collection<Integer> idCollection){
        Collection<Booking> bookingCollection = new ArrayList<>();

        for (Integer id: idCollection) {
            Booking booking = new Booking();
            booking.setId(id);
            bookingCollection.add(booking);
        }
        return bookingCollection;
    }

    @Named("eToIdBooking")
    default Collection<Integer> eToIdBooking(Collection<Booking> bookingCollection){
        return bookingCollection.stream().map(CommonEntity::getId).collect(Collectors.toList());
    }


   /* @Named("idToEActor")
    default Collection<Actors> idToEActor(Collection<Integer> idCollection){

    }*/

}
