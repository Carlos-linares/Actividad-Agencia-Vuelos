package fligtht.Booking.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.UUID;

public class VuelostoSalve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String FigthNumber;
    private String Origen;
    private String Destination;
    private String departituretime;

    // Getters manuales
    public String getFigthNumber() {
        return FigthNumber;
    }

    public String getOrigen() {
        return Origen;
    }

    public String getDestination() {
        return Destination;
    }

    public String getDepartituretime() {
        return departituretime;
    }
}
