package com.lad.springserver.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Actors extends CommonEntity  {
  /*  @Id@Column(name = "id")
    private int id;*/
    @Basic@Column(name = "name")
    private String name;
    @Basic@Column(name = "biography")
    private String biography;
    //@OneToMany(mappedBy = "actorsByIdActor")
    //private Collection<ActorPerformance> actorPerformancesById;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ActorPerformance",
            joinColumns = @JoinColumn(name = "id_actor"),
            inverseJoinColumns = @JoinColumn(name="id_performance")
    )
    private Set<Performances> performances;


    public Actors() {
    }

    /*  public Collection<ActorPerformance> getActorPerformancesById() {
        return this.actorPerformancesById;
    }*/

    /*  public void setActorPerformancesById(Collection<ActorPerformance> actorPerformancesById) {
        this.actorPerformancesById = actorPerformancesById;
    }*/

    protected boolean canEqual(final Object other) {
        return other instanceof Actors;
    }

    /*  public String toString() {
        return "Actors(id=" + this.getId() + ", name=" + this.getName() + ", biography=" + this.getBiography() + ", actorPerformancesById=" + this.getActorPerformancesById() + ")";
    }*/
}
