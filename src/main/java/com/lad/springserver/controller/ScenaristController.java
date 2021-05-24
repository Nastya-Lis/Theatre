package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.ScenaristMapping;
import com.lad.springserver.model.dto.ScenaristDto;
import com.lad.springserver.model.entity.Scenarists;
import com.lad.springserver.model.repository.ScenaristRepository;
import com.lad.springserver.model.service.ScenaristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("scenarists")
public class ScenaristController extends CommonController<Scenarists, ScenaristRepository, ScenaristDto, ScenaristService, ScenaristMapping>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ScenaristController(ScenaristMapping mapper, ScenaristService service) {
        super(mapper, service);
    }
}
