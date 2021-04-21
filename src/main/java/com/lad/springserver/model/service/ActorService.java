package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.repository.ActorRepository;
import com.lad.springserver.model.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService extends CommonServiceOperation<Actors, ActorRepository>{

    @Autowired
    public ActorService(ActorRepository repository) {
        super(repository);
    }


}
