package fligtht.Booking.Services;

import fligtht.Booking.dto.VuelosDto;
import fligtht.Booking.dto.VuelostoSalve;
import fligtht.Booking.Entity.Vuelos;
import fligtht.Booking.exception.VuelosNotFoundException;
import fligtht.Booking.repository.VuelosRepository;
import fligtht.Booking.Mapper.VuelosMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VuelosServiceImpl implements VuelosService {

    private final VuelosRepository vuelosRepository;
    private final VuelosMapper vuelosMapper;

    public VuelosServiceImpl(VuelosRepository vuelosRepository, VuelosMapper vuelosMapper) {
        this.vuelosRepository = vuelosRepository;
        this.vuelosMapper = vuelosMapper;
    }

    @Override
    public VuelosDto saveVuelo(VuelostoSalve vuelostoSalve) {
        Vuelos vueloToSave = vuelosMapper.vuelosToSaveDtoToVuelosEntity(vuelostoSalve);
        Vuelos vueloSaved = vuelosRepository.save(vueloToSave);
        return vuelosMapper.vuelosEntityToVuelosDto(vueloSaved);
    }

    @Override
    public VuelosDto findById(UUID id) throws VuelosNotFoundException {
        Optional<Vuelos> vuelo = vuelosRepository.findById(id);

        if (vuelo.isEmpty())
            throw new VuelosNotFoundException("Vuelo con ID " + id + " no encontrado");

        return vuelosMapper.vuelosEntityToVuelosDto(vuelo.get());
    }

    @Override
    public List<VuelosDto> findByOrigenAndDestination(String origen, String destination) throws VuelosNotFoundException {
        List<Vuelos> vuelosFound = vuelosRepository.findByOrigenAndDestination(origen, destination);

        if (vuelosFound.isEmpty())
            throw new VuelosNotFoundException("No se encontraron vuelos con origen: " + origen + " y destino: " + destination);

        List<VuelosDto> vuelosToReturn = new ArrayList<>();

        vuelosFound.forEach(vuelo -> {
            VuelosDto vueloMapeado = vuelosMapper.vuelosEntityToVuelosDto(vuelo);
            vuelosToReturn.add(vueloMapeado);
        });

        return vuelosToReturn;
    }


    public VuelosDto updateVueloById(VuelostoSalve vuelostoSalve, UUID id) throws VuelosNotFoundException {
        return null;
    }

    @SneakyThrows

    public VuelosDto updateVueloById(UUID id, VuelostoSalve vuelostoSalve) {
        Optional<Vuelos> vueloConsultado = vuelosRepository.findById(id);

        if (vueloConsultado.isEmpty())
            throw new VuelosNotFoundException("Vuelo con ID " + id + " no encontrado");

        Vuelos vuelo = vueloConsultado.get();


        if (vuelostoSalve.getFigthNumber() != null) vuelo.setFlightNumber(vuelostoSalve.getFigthNumber());
        if (vuelostoSalve.getOrigen() != null) vuelo.setOrigin(vuelostoSalve.getOrigen());
        if (vuelostoSalve.getDestination() != null) vuelo.setDestination(vuelostoSalve.getDestination());
        if (vuelostoSalve.getDepartituretime() != null) vuelo.setDepartureTime(vuelostoSalve.getDepartituretime());
        Vuelos updatedVuelo = vuelosRepository.save(vuelo);

        return vuelosMapper.vuelosEntityToVuelosDto(updatedVuelo);
    }

    @SneakyThrows
    @Override
    public void deleteVueloById(UUID id) {
        Optional<Vuelos> vueloToDelete = vuelosRepository.findById(id);

        if (vueloToDelete.isEmpty())
            throw new VuelosNotFoundException("Vuelo con ID " + id + " no existe");

        vuelosRepository.deleteById(id);
    }

    @SneakyThrows
    @Override
    public List<VuelosDto> findVueloByFigthNumber(String figthNumber) {
        List<Vuelos> vuelosMatch = vuelosRepository.findByFigthNumber(figthNumber);

        if (vuelosMatch.isEmpty())
            throw new VuelosNotFoundException("No se encontraron vuelos con el número de vuelo: " + figthNumber);

        List<VuelosDto> vuelosToReturn = new ArrayList<>();

        vuelosMatch.forEach(vuelo -> {
            VuelosDto vueloMapeado = vuelosMapper.vuelosEntityToVuelosDto(vuelo);
            vuelosToReturn.add(vueloMapeado);
        });

        return vuelosToReturn;
    }
}
