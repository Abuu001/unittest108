package io.lugonzo.unittesting108.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.lugonzo.unittesting108.enums.FlightType;
import io.lugonzo.unittesting108.model.Booking;
import io.lugonzo.unittesting108.service.BookingService;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test if booking controller returns a booking flight")
    void getbooking() throws Exception {

        when(bookingService.retrieve())
                .thenReturn(new Booking("JZXMLA7","Jude", FlightType.BUSINESSCLASS,453L));   //mock out booking service & test only booking controller

        RequestBuilder request = MockMvcRequestBuilders
                .get("/book-flight")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"JZXMLA7\",\"name\":\"Jude\",\"flightType\":\"BUSINESSCLASS\",\"seatNo\":453}"))
                .andReturn();
    }

    @Test
    @DisplayName("Test for all bookings in the list")
    void getAllbookings() throws Exception {

        when(bookingService.retrieveAllBookings())
                    .thenReturn(Arrays.asList(
                            new Booking("1","Kel", FlightType.PREMIUMECONOMY,64_323L),
                            new Booking("2","Mel", FlightType.BUSINESSCLASS,98_223L),
                            new Booking("3","Sel", FlightType.FIRSTCLASS,98_732L),
                            new Booking("4","Zel", FlightType.PREMIUMECONOMY,92_332L)
                    ));

           RequestBuilder request = MockMvcRequestBuilders
                .get("/all-book-flight")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json( "[{\"id\":\"1\",\"name\":\"Kel\",\"flightType\":\"PREMIUMECONOMY\",\"seatNo\":64323},{\"id\":\"2\",\"name\":\"Mel\",\"flightType\":\"BUSINESSCLASS\",\"seatNo\":98223},{\"id\":\"3\",\"name\":\"Sel\",\"flightType\":\"FIRSTCLASS\",\"seatNo\":98732},{\"id\":\"4\",\"name\":\"Zel\",\"flightType\":\"PREMIUMECONOMY\",\"seatNo\":92332}]"))
                .andReturn();
    }


    @Test
    @DisplayName("Test for creating a booking flight")
    void createBooking() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/add-flight")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"5\",\"name\":\"Gel\",\"flightType\":\"PREMIUMECONOMY\",\"seatNo\":623784}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                //.andExpect(header())
                .andReturn();

    }
}

