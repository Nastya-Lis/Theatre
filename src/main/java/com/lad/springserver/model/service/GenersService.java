package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.repository.GenresRepository;

public class GenersService extends CommonServiceOperation<Geners,GenresRepository>{

    public GenersService(GenresRepository repository) {
        super(repository);
    }
}
