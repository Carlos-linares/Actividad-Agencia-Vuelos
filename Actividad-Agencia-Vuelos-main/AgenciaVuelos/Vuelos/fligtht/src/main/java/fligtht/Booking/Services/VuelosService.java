package fligtht.Booking.Services;

import fligtht.Booking.dto.VuelosDto;
import fligtht.Booking.dto.VuelostoSalve;
import fligtht.Booking.exception.VuelosNotFoundException;
import lombok.SneakyThrows;

import java.util.List;
import java.util.UUID;

public interface VuelosService {
    VuelosDto saveVuelo(VuelostoSalve vuelostoSalve);
    VuelosDto findById(UUID id) throws VuelosNotFoundException;
    List<VuelosDto> findByOrigenAndDestination(String origen, String destination) throws VuelosNotFoundException;
    VuelosDto updateVueloById(UUID id, VuelostoSalve vuelostoSalve) throws VuelosNotFoundException;

    @SneakyThrows


    void deleteVueloById(UUID id);
    List<VuelosDto> findVueloByFigthNumber(String figthNumber);
}
