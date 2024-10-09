package com.Booking.BookingService.Mapper;

import com.Booking.BookingService.Entity.Booking;
import com.Booking.BookingService.dto.Bookingmostrardto;
import com.Booking.BookingService.dto.Bookingtosalvedto;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-09T13:38:58-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public Bookingmostrardto bookingToBookingDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        UUID id = null;
        String flightNumber = null;
        String passengerName = null;

        id = booking.getId();
        flightNumber = booking.getFlightNumber();
        passengerName = booking.getPassengerName();

        Bookingmostrardto bookingmostrardto = new Bookingmostrardto( id, flightNumber, passengerName );

        return bookingmostrardto;
    }

    @Override
    public Booking bookingDtoToBooking(Bookingtosalvedto bookingdto) {
        if ( bookingdto == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.id( bookingdto.id() );
        booking.flightNumber( bookingdto.flightNumber() );
        booking.passengerName( bookingdto.passengerName() );

        return booking.build();
    }

    @Override
    public Bookingtosalvedto bookingEntityToBookingToSaveDto(Booking savedBooking) {
        if ( savedBooking == null ) {
            return null;
        }

        UUID id = null;
        String flightNumber = null;
        String passengerName = null;

        id = savedBooking.getId();
        flightNumber = savedBooking.getFlightNumber();
        passengerName = savedBooking.getPassengerName();

        Bookingtosalvedto bookingtosalvedto = new Bookingtosalvedto( id, flightNumber, passengerName );

        return bookingtosalvedto;
    }
}
