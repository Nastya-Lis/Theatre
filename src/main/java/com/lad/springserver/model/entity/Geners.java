package com.lad.springserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Geners extends CommonEntity {
    //private int id;
    private String nameType;

    @OneToMany(targetEntity = Performances.class ,mappedBy = "genersByGenre", fetch=FetchType.EAGER)
    private Collection<Performances> performancesById;
//    @Id
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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
        return /*id == geners.id &&*/ Objects.equals(nameType, geners.nameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*id,*/ nameType);
    }



    public Collection<Performances> getPerformancesById() {
        return performancesById;
    }

    public void setPerformancesById(Collection<Performances> performancesById) {
        this.performancesById = performancesById;
    }
}
