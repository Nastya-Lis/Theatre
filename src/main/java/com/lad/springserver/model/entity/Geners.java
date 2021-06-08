package com.lad.springserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Geners extends CommonEntity {

    private String nameType;

    @OneToMany(targetEntity = Performances.class ,mappedBy = "genersByGenre", fetch=FetchType.EAGER)
    private Collection<Performances> performancesById;

    @Basic
    @Column(name = "name_type")
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geners geners = (Geners) o;
        return Objects.equals(nameType, geners.nameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameType);
    }


    public Collection<Performances> getPerformancesById() {
        return performancesById;
    }

    public void setPerformancesById(Collection<Performances> performancesById) {
        this.performancesById = performancesById;
    }
}
