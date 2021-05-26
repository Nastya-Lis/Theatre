package com.lad.springserver.controller;

import com.lad.springserver.controller.mapping.PerformanceMapping;
import com.lad.springserver.model.dto.PerformanceDto;
import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.PerformanceRepository;
import com.lad.springserver.model.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("performances")
public class PerformanceController extends CommonController<Performances,PerformanceRepository, PerformanceDto, PerformanceService, PerformanceMapping>{

    @Autowired
    PerformanceService performanceService;

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


    @PostMapping("/rating")
    public String changeRatingPerformance(@RequestParam Boolean mark,@RequestParam Integer idPerform){
        Double staticCoefficient = 5.7;
        Performances performance = performanceService.getPerformanceById(idPerform);
        Double currentRating = performance.getRating();
        if(mark == true){
            if(currentRating+staticCoefficient <= 100)
            performance.setRating(currentRating + staticCoefficient);
            else
                performance.setRating(100);
        }
        else{
            if(currentRating-staticCoefficient > 0 )
                performance.setRating(currentRating - staticCoefficient);
            else
                performance.setRating(0);
        }
        performanceService.updateEntity(performance,idPerform);

        return "your opinion is taken into account";
    }
}
