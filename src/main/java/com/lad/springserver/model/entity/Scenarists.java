package com.lad.springserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Scenarists extends CommonEntity {
   // private int id;
    private String name;
    private String biography;
    //private Collection<ScenaristPerformance> scenaristPerformancesById;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ScenaristPerformance",
            joinColumns = @JoinColumn(name = "id_scenarist"),
            inverseJoinColumns = @JoinColumn(name = "id_performance")
    )
    private Set<Performances> performances;

   /* @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "biography")
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenarists that = (Scenarists) o;
        return /*id == that.id && */Objects.equals(name, that.name) && Objects.equals(biography, that.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*id, */name, biography);
    }
/*
    @OneToMany(mappedBy = "scenaristsByIdScenarist")
    public Collection<ScenaristPerformance> getScenaristPerformancesById() {
        return scenaristPerformancesById;
    }

    public void setScenaristPerformancesById(Collection<ScenaristPerformance> scenaristPerformancesById) {
        this.scenaristPerformancesById = scenaristPerformancesById;
    }*/
}
