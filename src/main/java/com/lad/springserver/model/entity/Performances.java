package com.lad.springserver.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Performances extends CommonEntity {
   // private int id;
    private String description;
    private Timestamp date;
    private String duration;
    private int amountTickets;
    private double price;
    private double rating;
  //  private Collection<ActorPerformance> actorPerformancesById;
    private Collection<Booking> bookingsById;
    private Geners genersByGenre;
   // private Collection<ScenaristPerformance> scenaristPerformancesById;

    @ManyToMany(mappedBy = "performances",fetch = FetchType.EAGER)
    private Set<Actors> actorsSet;

    @ManyToMany(mappedBy = "performances", fetch = FetchType.EAGER)
    private Set<Scenarists> scenaristsSet;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "amount_tickets")
    public int getAmmountTickets() {
        return amountTickets;
    }

    public void setAmmountTickets(int ammountTickets) {
        this.amountTickets = ammountTickets;
    }


    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "rating")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performances that = (Performances) o;
        return /*id == that.id &&*/ amountTickets == that.amountTickets && Double.compare(that.price, price) == 0 && Double.compare(that.rating, rating) == 0 && Objects.equals(description, that.description) && Objects.equals(date, that.date)  && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*id,*/ description, date, duration, amountTickets,price, rating);
    }

   /* @OneToMany(mappedBy = "performancesByIdPerformance")
    public Collection<ActorPerformance> getActorPerformancesById() {
        return actorPerformancesById;
    }

    public void setActorPerformancesById(Collection<ActorPerformance> actorPerformancesById) {
        this.actorPerformancesById = actorPerformancesById;
    }*/

    @OneToMany(mappedBy = "performancesByIdPerformance")
    public Collection<Booking> getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(Collection<Booking> bookingsById) {
        this.bookingsById = bookingsById;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    public Geners getGenersByGenre() {
        return genersByGenre;
    }

    public void setGenersByGenre(Geners genersByGenre) {
        this.genersByGenre = genersByGenre;
    }

   /* @OneToMany(mappedBy = "performancesByIiPerformance")
    public Collection<ScenaristPerformance> getScenaristPerformancesById() {
        return scenaristPerformancesById;
    }

    public void setScenaristPerformancesById(Collection<ScenaristPerformance> scenaristPerformancesById) {
        this.scenaristPerformancesById = scenaristPerformancesById;
    }*/
}
