package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Scenarists;
import com.lad.springserver.model.repository.ScenaristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenaristService extends CommonServiceOperation<Scenarists, ScenaristRepository>{
    @Autowired
    public ScenaristService(ScenaristRepository repository) {
        super(repository);
    }
}
