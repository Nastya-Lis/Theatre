package com.lad.springserver.controller;

import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceController(PerformanceRepository repository){
        this.performanceRepository = repository;
    }

    @GetMapping("/all")
    public List<Performances> getAllPerformances(){
       return performanceRepository.findAll();
    }

}
