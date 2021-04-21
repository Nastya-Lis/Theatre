package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.repository.BookingRepository;


public class BookingService extends CommonServiceOperation<Booking, BookingRepository> {
    public BookingService(BookingRepository repository) {
        super(repository);
    }
}
