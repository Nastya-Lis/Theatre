package com.lad.springserver.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Booking extends CommonEntity {
    //private int id;
    private int amount;
    private Users usersByIdUser;
    private Performances performancesByIdPerformance;

   /* @Id
    @Column(name = "id")
    public int getIdBooking() {
        return id;
    }

    public void setIdBooking(int idBooking) {
        this.id = idBooking;
    }*/

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return /*id == booking.id &&*/ amount == booking.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*id, */amount);
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    public Users getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(Users usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_performance", referencedColumnName = "id", nullable = false)
    public Performances getPerformancesByIdPerformance() {
        return performancesByIdPerformance;
    }

    public void setPerformancesByIdPerformance(Performances performancesByIdPerformance) {
        this.performancesByIdPerformance = performancesByIdPerformance;
    }
}
