package com.lad.springserver.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class CommonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

   /* public CommonEntity(){

    }

    public CommonEntity(int id){
        this.id = id;
    }*/
}
