package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Scenarists;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenaristRepository extends IRepository<Scenarists>{
    @Override
    List<Scenarists> findAll(Sort sort);
}
