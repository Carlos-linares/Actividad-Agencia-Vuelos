package com.Booking.BookingService.dto;

import java.util.UUID;

public record Bookingtosalvedto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}