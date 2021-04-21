package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Performances;
import lombok.Data;

import java.util.Collection;

@Data
public class GenreDto extends AbstractDto{
    private String nameType;
    private Collection<Integer> performancesId;
}
