package fligtht.Booking.dto;

import java.util.UUID;

public record VuelosDto(
        UUID id,
         String FigthNumber,
         String Origen,
        String Destination,
        String departituretime

) {
}
