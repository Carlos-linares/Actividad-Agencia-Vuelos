package com.Booking.BookingService.dto;

import java.util.UUID;

public record Bookingdto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}