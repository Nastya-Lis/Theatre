package com.lad.springserver.controller.mapping;

import com.lad.springserver.model.dto.AbstractDto;
import com.lad.springserver.model.entity.CommonEntity;

import java.util.ArrayList;
import java.util.List;


public interface CommonMapping<E extends CommonEntity,D extends AbstractDto>{

    E dtoToEntity(D dto);
    D entityToDto(E entity);

    default List<E> dtosToEntities(List<D> dtoes){
        List<E> entities = new ArrayList<>();
        for(D dto:dtoes){
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    default List<D> entitiesToDtos(List<E> entities){
        List<D> dtoes = new ArrayList<>();
        for(E entity:entities){
            dtoes.add(entityToDto(entity));
        }
        return dtoes;
    }
}
