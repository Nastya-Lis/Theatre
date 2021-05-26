package com.lad.springserver.controller;


import com.lad.springserver.controller.mapping.BookingMapping;
import com.lad.springserver.model.dto.BookingDto;
import com.lad.springserver.model.entity.Booking;
import com.lad.springserver.model.entity.Performances;
import com.lad.springserver.model.repository.BookingRepository;
import com.lad.springserver.model.repository.PerformanceRepository;
import com.lad.springserver.model.repository.UserRepository;
import com.lad.springserver.model.service.BookingService;
import com.lad.springserver.model.service.PerformanceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bookings")
public class BookingController extends CommonController<Booking, BookingRepository, BookingDto, BookingService, BookingMapping>{

    @Autowired
    BookingMapping bookingMapping;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PerformanceRepository performanceRepository;

    @Autowired
    PerformanceService performanceService;

    @Autowired
    public BookingController(BookingMapping mapper, BookingService service) {
        super(mapper, service);
    }

    @PostMapping("/add")
    public String getDataFromMobile(@RequestParam Integer amount,@RequestParam Integer userId,@RequestParam Integer performanceId){
        /*BookingDto bookingDto1 = new BookingDto();
        bookingDto1.setAmount(bookingDto.getAmount());
        bookingDto1.setPerformance(bookingDto.getPerformance());
        bookingDto1.setUser(bookingDto.getUser());*/

        Booking bookingToSave = new Booking();
        bookingToSave.setAmount(amount);
        bookingToSave.setUsersByIdUser(userRepository.findUsersById(userId));
        bookingToSave.setPerformancesByIdPerformance(performanceRepository.findPerformancesById(performanceId));

        Performances performance = performanceRepository.findPerformancesById(performanceId);
        performance.setAmountTickets(performance.getAmountTickets() - amount);
     /*   Booking booking = bookingMapping.dtoToEntity(bookingDto);
        Booking bookingWithNewId = new Booking();
        bookingWithNewId.setAmount(booking.getAmount());
        bookingWithNewId.setPerformancesByIdPerformance(booking.getPerformancesByIdPerformance());
        bookingWithNewId.setUsersByIdUser(booking.getUsersByIdUser());*/


        bookingRepository.save(bookingToSave);
        performanceService.updateEntity(performance,performanceId);

        //Response response = new Response();
       // response.setStatus(response.is);
        return "oh haee poco";
    }
}
