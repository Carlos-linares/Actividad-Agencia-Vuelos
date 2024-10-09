package com.Booking.BookingService.Mapper;

import com.Booking.BookingService.dto.Bookingmostrardto;
import com.Booking.BookingService.Entity.Booking;

import com.Booking.BookingService.dto.Bookingtosalvedto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "flightNumber", target = "flightNumber"),
            @Mapping(source = "passengerName", target = "passengerName")
    })
    Bookingmostrardto bookingToBookingDto(Booking booking);


    @InheritInverseConfiguration
    Booking bookingDtoToBooking(Bookingtosalvedto bookingdto);

    Bookingtosalvedto bookingEntityToBookingToSaveDto(Booking savedBooking);
}
