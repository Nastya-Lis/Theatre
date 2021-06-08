package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.GenreMapping;
import com.lad.springserver.model.dto.GenreDto;
import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.repository.GenresRepository;
import com.lad.springserver.model.service.GenersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController extends CommonController<Geners,GenresRepository, GenreDto, GenersService, GenreMapping>{
   @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public GenreController(GenreMapping mapper, GenersService service) {
        super(mapper, service);
    }


}
