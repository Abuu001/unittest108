package io.lugonzo.unittesting108.service;

import io.lugonzo.unittesting108.enums.FlightType;
import io.lugonzo.unittesting108.model.Booking;
import io.lugonzo.unittesting108.repository.BookingRepository;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking retrieve() {
        var flight1 =  Booking.builder()
                .id("JZXMLA7")
                .name("Jude")
                .flightType(FlightType.BUSINESSCLASS)
                .seatNo(453L)
                .build();

        return  flight1;
    }

    public List<Booking> retrieveAllBookings(){
       return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return  bookingRepository.save(booking);
    }
}
