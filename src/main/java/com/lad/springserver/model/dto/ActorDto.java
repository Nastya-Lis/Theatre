package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Performances;
import lombok.Data;

import java.util.Set;


@Data
public class ActorDto extends AbstractDto {
    private String name;
    private String biography;
    private Set<PerformanceDto> performances;
}
