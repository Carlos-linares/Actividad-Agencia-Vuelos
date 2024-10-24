package fligtht.Booking.repository;

import fligtht.Booking.Entity.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VuelosRepository extends JpaRepository<Vuelos, Long> {

    Optional<Vuelos> findById(UUID id);

    // Query Methods

    // Simples
    List<Vuelos> findByFigthNumber(String figthNumber);
    List<Vuelos> findByOrigen(String origen);
    List<Vuelos> findByDestination(String destination);
    List<Vuelos> findByDepartituretime(String departituretime);

    // Compuestos
    List<Vuelos> findByOrigenAndDestination(String origen, String destination);
    List<Vuelos> findByFigthNumberAndOrigen(String figthNumber, String origen);
    List<Vuelos> findByDestinationAndDepartituretime(String destination, String departituretime);

    void deleteById(UUID id);
}
