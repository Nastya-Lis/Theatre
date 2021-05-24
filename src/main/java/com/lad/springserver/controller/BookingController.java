package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.BookingMapping;
import com.lad.springserver.model.dto.BookingDto;
import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.repository.BookingRepository;
import com.lad.springserver.model.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
public class BookingController extends CommonController<Booking, BookingRepository, BookingDto, BookingService, BookingMapping>{

    @Autowired
    public BookingController(BookingMapping mapper, BookingService service) {
        super(mapper, service);
    }
}
