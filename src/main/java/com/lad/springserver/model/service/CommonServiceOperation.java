package com.lad.springserver.model.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.lad.springserver.model.entity.CommonEntity;
import com.lad.springserver.model.repository.IRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CommonServiceOperation<E extends CommonEntity, R extends IRepository<E>> {

    protected final R repository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CommonServiceOperation(R repository){
        this.repository = repository;
    }

    public void addEntity(E entity){
        repository.save(entity);
    }

    public void deleteEntity(int id){
        repository.deleteById(id);
    }

    public List<E> viewAll(){
        return repository.findAll();
    }

    public void updateEntity(E entity,int id){
        repository.findById(id).ifPresent(entityFromDb ->{
                BeanUtils.copyProperties(entity,entityFromDb, String.valueOf(id));
                repository.save(entityFromDb);
        });
    }

    public Optional<E> findById(int id){
        return repository.findById(id);
    }

}
