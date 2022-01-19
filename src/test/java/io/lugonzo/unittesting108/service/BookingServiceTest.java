package io.lugonzo.unittesting108.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import io.lugonzo.unittesting108.enums.FlightType;
import io.lugonzo.unittesting108.model.Booking;
import io.lugonzo.unittesting108.repository.BookingRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Test
    void retrieveAllBookings() {

        when(bookingRepository.findAll()).thenReturn(Arrays.asList(
                new Booking("1","Kel", FlightType.PREMIUMECONOMY,64_323L),
                new Booking("2","Mel", FlightType.BUSINESSCLASS,98_223L),
                new Booking("3","Sel", FlightType.FIRSTCLASS,98_732L),
                new Booking("4","Zel", FlightType.PREMIUMECONOMY,92_332L)
        ));

        int noOfBookings = bookingService.retrieveAllBookings().size();
       List<Booking> bookings =  bookingService.retrieveAllBookings();

       assertAll(
               ()->  assertEquals(4,noOfBookings ),
               ()-> assertEquals(FlightType.PREMIUMECONOMY , bookings.get(3).getFlightType()),
               ()-> assertEquals(98_223L,bookings.get(1).getSeatNo())
       );

    }

}