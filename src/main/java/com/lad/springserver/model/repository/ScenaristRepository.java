package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Scenarists;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScenaristRepository extends IRepository<Scenarists>{
    @Override
    List<Scenarists> findAll(Sort sort);

}
