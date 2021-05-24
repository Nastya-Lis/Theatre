package com.lad.springserver.controller;

import com.lad.springserver.controller.mapping.PerformanceMapping;
import com.lad.springserver.model.dto.PerformanceDto;
import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.PerformanceRepository;
import com.lad.springserver.model.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("performances")
public class PerformanceController extends CommonController<Performances,PerformanceRepository, PerformanceDto, PerformanceService, PerformanceMapping>{

    @Autowired
    public PerformanceController(PerformanceMapping mapper, PerformanceService service) {
        super(mapper, service);
    }

   /* private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceController(PerformanceRepository repository){
        this.performanceRepository = repository;
    }
*/
    /*@GetMapping("/all")
    public List<Performances> getAllPerformances(){
       return performanceRepository.findAll();
    }*/

}
