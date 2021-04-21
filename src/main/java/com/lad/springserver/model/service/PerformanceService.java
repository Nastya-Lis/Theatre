package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.PerformanceRepository;

public class PerformanceService extends CommonServiceOperation<Performances, PerformanceRepository>{
    public PerformanceService(PerformanceRepository repository) {
        super(repository);
    }
}
