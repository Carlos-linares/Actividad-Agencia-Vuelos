package com.Booking.BookingService.Services;

import com.Booking.BookingService.dto.Bookingmostrardto;
import com.Booking.BookingService.dto.Bookingtosalvedto;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    Bookingtosalvedto saveBooking(Bookingtosalvedto booking);
    Bookingmostrardto updateBooking(UUID id, Bookingtosalvedto booking);
    Bookingmostrardto findBookingById(UUID id);
    List<Bookingmostrardto> findAllBookings();
    void deleteBooking(UUID id);
}
