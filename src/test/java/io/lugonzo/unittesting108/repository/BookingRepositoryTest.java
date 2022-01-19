package io.lugonzo.unittesting108.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.lugonzo.unittesting108.enums.FlightType;
import io.lugonzo.unittesting108.model.Booking;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testFindAll(){
       List<Booking> allBookings = bookingRepository.findAll();
       assertEquals(4,allBookings.size());

       assertEquals(FlightType.PREMIUMECONOMY,allBookings.get(0).getFlightType());
    }
}