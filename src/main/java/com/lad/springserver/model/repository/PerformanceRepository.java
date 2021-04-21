package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.entity.Performances;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerformanceRepository extends IRepository<Performances>{
    Optional<Performances> findPerformancesByGenersByGenre(Geners gener);
}
