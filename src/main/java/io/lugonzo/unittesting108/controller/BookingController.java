package io.lugonzo.unittesting108.controller;

import io.lugonzo.unittesting108.model.Booking;
import io.lugonzo.unittesting108.model.Student;
import io.lugonzo.unittesting108.service.BookingService;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/book-flight")
    public Booking getbooking(){
        return bookingService.retrieve();
    }

    @GetMapping("/all-book-flight")
    public List<Booking> getAllbookings(){
        return bookingService.retrieveAllBookings();
    }

    @PostMapping("/add-flight")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }
}
