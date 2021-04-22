package com.lad.springserver.model.dto;

import com.lad.springserver.model.entity.Actors;
import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.entity.Geners;
import com.lad.springserver.model.entity.Scenarists;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;


@Data
public class PerformanceDto extends AbstractDto{
    private String description;
    private Timestamp date;
    private String duration;
    private int amountTickets;
    private double price;
    private double rating;
    private Collection<BookingDto> bookings;
    private GenreDto genre;
    public Collection<ActorDto> actors;
    public Collection<ScenaristDto> scenarists;
}
