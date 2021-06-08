package com.lad.springserver.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Actors extends CommonEntity  {

    @Basic@Column(name = "name")
    private String name;
    @Basic@Column(name = "biography")
    private String biography;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ActorPerformance",
            joinColumns = @JoinColumn(name = "id_actor"),
            inverseJoinColumns = @JoinColumn(name="id_performance")
    )
    private Set<Performances> performances;


    public Actors() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Actors;
    }

}
