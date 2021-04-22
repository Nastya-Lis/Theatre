package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenersService extends CommonServiceOperation<Geners,GenresRepository>{

    @Autowired
    public GenersService(GenresRepository repository) {
        super(repository);
    }
}
