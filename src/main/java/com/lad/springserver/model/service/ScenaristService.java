package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Scenarists;
import com.lad.springserver.model.repository.ScenaristRepository;

public class ScenaristService extends CommonServiceOperation<Scenarists, ScenaristRepository>{
    public ScenaristService(ScenaristRepository repository) {
        super(repository);
    }
}
