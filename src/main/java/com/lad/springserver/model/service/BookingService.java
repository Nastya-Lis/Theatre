package com.lad.springserver.model.service;

import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends CommonServiceOperation<Booking, BookingRepository> {
    @Autowired
    public BookingService(BookingRepository repository) {
        super(repository);
    }
}
