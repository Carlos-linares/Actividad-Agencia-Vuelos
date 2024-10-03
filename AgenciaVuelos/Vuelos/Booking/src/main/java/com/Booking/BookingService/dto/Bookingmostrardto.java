package com.Booking.BookingService.dto;
import java.util.UUID;
public record Bookingmostrardto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}
