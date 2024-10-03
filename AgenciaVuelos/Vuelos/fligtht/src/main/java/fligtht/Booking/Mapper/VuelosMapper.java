package fligtht.Booking.Mapper;
import fligtht.Booking.Entity.Vuelos;
import fligtht.Booking.dto.VuelosDto;
import fligtht.Booking.dto.VuelostoSalve;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VuelosMapper {

    VuelosMapper INSTANCE = Mappers.getMapper(VuelosMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "FigthNumber", target = "FigthNumber"),
            @Mapping(source = "Origen", target = "Origen"),
            @Mapping(source = "Destination", target = "Destination"),
            @Mapping(source = "departituretime", target = "departituretime"),
    })
    VuelosDto vuelosEntityToVuelosDto(Vuelos vuelos);

    @InheritInverseConfiguration
    Vuelos vuelosDtoToVuelosEntity(VuelosDto vuelosDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "FigthNumber", target = "FigthNumber"),
            @Mapping(source = "Origen", target = "Origen"),
            @Mapping(source = "Destination", target = "Destination"),
            @Mapping(source = "departituretime", target = "departituretime"),
    })
    VuelostoSalve vuelosEntityToVuelosToSalve(Vuelos vuelos);

    @InheritInverseConfiguration
    Vuelos vuelosToSaveDtoToVuelosEntity(VuelostoSalve vuelosToSalve);
}
