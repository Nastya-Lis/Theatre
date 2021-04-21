package com.lad.springserver.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractDto implements Serializable {
    private int id;
}
