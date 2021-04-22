package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.BookingDto;
import com.lad.springserver.model.dto.PerformanceDto;
import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;


@Mapper(componentModel = "spring", uses = {PerformanceMapping.class,UserMapping.class})
public interface BookingMapping extends CommonMapping<Booking, BookingDto>{
    @Mappings({
            @Mapping(target = "performancesByIdPerformance", source = "performance",qualifiedByName = "idToEPerform"),
            @Mapping(target = "usersByIdUser", source = "user",qualifiedByName = "idToEUser")
    })
    Booking dtoToEntity(BookingDto dto);

    @Mappings({
            @Mapping(target = "performance", source = "performancesByIdPerformance", qualifiedByName = "eToIdPerform"),
            @Mapping(target = "user", source = "usersByIdUser",  qualifiedByName = "eToIdUser" )
    })
    BookingDto entityToDto(Booking booking);


    @Named("idToEPerform")
    default Performances idToEPerform(Integer id){
        Performances performance = new Performances();
        performance.setId(id);
        return performance;
    }

    @Named("eToIdPerform")
    default Integer eToIdPerform(Performances performance){
        return performance.getId();
    }

    @Named("idToEUser")
    default Users idToEUser(Integer id){
        Users user = new Users();
        user.setId(id);
        return user;
    }

    @Named("eToIdUser")
    default Integer eToIdUser(Users user){
        return user.getId();
    }



}
