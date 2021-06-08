package com.lad.springserver.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;


@Entity
public class Performances extends CommonEntity {
    private String name;
    private String description;
    private Timestamp date;
    private String duration;
    private int amountTickets;
    private double price;
    private double rating;

    @OneToMany(mappedBy = "performancesByIdPerformance")
    private Collection<Booking> bookingsById;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Geners genersByGenre;

    @ManyToMany(mappedBy = "performances")
    public Collection<Actors> actorsSet;

    @ManyToMany(mappedBy = "performances")
    public Collection<Scenarists> scenaristsSet;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    public int getAmountTickets() {
        return amountTickets;
    }

    public void setAmountTickets(int amountTickets) {
        this.amountTickets = amountTickets;
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
        return amountTickets == that.amountTickets && Double.compare(that.price, price) == 0 && Double.compare(that.rating, rating) == 0 && Objects.equals(description, that.description) && Objects.equals(date, that.date)  && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date, duration, amountTickets,price, rating);
    }

    public Collection<Booking> getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(Collection<Booking> bookingsById) {
        this.bookingsById = bookingsById;
    }



    public Geners getGenersByGenre() {
        return genersByGenre;
    }

    public void setGenersByGenre(Geners genersByGenre) {
        this.genersByGenre = genersByGenre;
    }
}
