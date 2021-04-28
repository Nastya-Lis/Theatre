package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.CommonMapping;
import com.lad.springserver.model.dto.AbstractDto;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.repository.IRepository;
import com.lad.springserver.model.service.CommonServiceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


public class CommonController<E extends CommonEntity,R extends IRepository<E>,D extends AbstractDto,S extends CommonServiceOperation<E,R>,M extends CommonMapping<E,D>>
{
    private M mapper;
    private S service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CommonController(M mapper,S service){
        this.mapper = mapper;
        this.service = service;
    }

   /* @GetMapping("all")
    public List<D> getAll(){
        return mapper.entitiesToDtos(service.viewAll());
    }*/


    @GetMapping
    public List<D> getAll() {
        return mapper.entitiesToDtos(service.viewAll());
    }

    @GetMapping("/{id}")
    public Optional<D> getById(@PathVariable("id") Integer id) {
        Optional<E> entity = service.findById(id);
        return entity.map(mapper::entityToDto);
    }

    @PostMapping
    public void save(@RequestBody @Valid D dto) {
        service.addEntity(mapper.dtoToEntity(dto));
    }

    @PutMapping
    public void update(@RequestBody @Valid D dto) {
        service.updateEntity(mapper.dtoToEntity(dto), dto.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteEntity(id);
    }

}
