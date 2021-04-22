package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerformanceService extends CommonServiceOperation<Performances, PerformanceRepository>{
    @Autowired
    public PerformanceService(PerformanceRepository repository) {
        super(repository);
    }
}
