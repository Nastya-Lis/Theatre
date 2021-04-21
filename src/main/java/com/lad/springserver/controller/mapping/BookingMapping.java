package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.BookingDto;
import com.lad.springserver.model.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookingMapping extends CommonMapping<Booking, BookingDto>{
    @Mappings({
            @Mapping(target = "performancesByIdPerformance", source = "performance"),
            @Mapping(target = "usersByIdUser", source = "user")
    })
    Booking dtoToEntity(BookingDto dto);

    @Mappings({
            @Mapping(target = "performance", source = "performancesByIdPerformance"),
            @Mapping(target = "user", source = "usersByIdUser")
    })
    BookingDto entityToDto(Booking booking);
}
