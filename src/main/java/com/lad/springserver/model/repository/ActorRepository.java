package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.entity.Performances;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ActorRepository extends IRepository<Actors>{
    Collection<Actors> findByPerformances(Performances performances);

    @Override
    List<Actors> findAll(Sort sort);

}
