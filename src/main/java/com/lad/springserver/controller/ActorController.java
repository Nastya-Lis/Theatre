package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.ActorMapping;
import com.lad.springserver.model.dto.ActorDto;
import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.repository.ActorRepository;
import com.lad.springserver.model.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/actors")
public class ActorController extends CommonController<Actors, ActorRepository, ActorDto, ActorService, ActorMapping> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ActorController(ActorMapping mapper, ActorService service) {
        super(mapper, service);
    }
}
