package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.ScenaristDto;
import com.lad.springserver.model.entity.Scenarists;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScenaristMapping extends CommonMapping<Scenarists, ScenaristDto>{

    Scenarists dtoToEntity(ScenaristDto dto);

    ScenaristDto entityToDto(Scenarists scenarists);
}
