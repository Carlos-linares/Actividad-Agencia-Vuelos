package fligtht.Booking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "vuelos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vuelos {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
}
