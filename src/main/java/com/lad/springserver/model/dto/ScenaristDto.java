package com.lad.springserver.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ScenaristDto extends AbstractDto{
    private String name;
    private String biography;
    private Set<Integer> performances;
}
