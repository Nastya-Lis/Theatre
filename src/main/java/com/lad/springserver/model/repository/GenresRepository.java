package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.entity.Performances;
import lombok.var;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface GenresRepository extends IRepository<Geners>{
    @Override
    List<Geners> findAll();


}
