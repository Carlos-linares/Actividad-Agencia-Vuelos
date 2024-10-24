package com.Booking.BookingService.Services;

import com.Booking.BookingService.Mapper.BookingMapper;
import com.Booking.BookingService.dto.Bookingmostrardto;
import com.Booking.BookingService.dto.Bookingtosalvedto;
import com.Booking.BookingService.Entity.Booking;
import com.Booking.BookingService.Exception.BookingNotFoundException;
import com.Booking.BookingService.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Bookingtosalvedto saveBooking(Bookingtosalvedto bookingToSave) {

        Booking bookingEntity = bookingMapper.bookingDtoToBooking(bookingToSave);

        Booking savedBooking = bookingRepository.save(bookingEntity);

        return bookingMapper.bookingEntityToBookingToSaveDto(savedBooking);
    }

    @Override
    public Bookingmostrardto findBookingById(UUID id) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty()) {
            throw new BookingNotFoundException("Booking con ID " + id + " no encontrado");
        }
        return bookingMapper.bookingToBookingDto(booking.get());
    }

    @Override
    public List<Bookingmostrardto> findAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<Bookingmostrardto> bookingsToReturn = new ArrayList<>();

        bookings.forEach(booking -> {
            Bookingmostrardto bookingDto = bookingMapper.bookingToBookingDto(booking);
            bookingsToReturn.add(bookingDto);
        });

        return bookingsToReturn;
    }

    @Override
    public Bookingmostrardto updateBooking(UUID id, Bookingtosalvedto bookingToSave) throws BookingNotFoundException {
        Optional<Booking> existingBooking = bookingRepository.findById(id);

        if (existingBooking.isEmpty()) {
            throw new BookingNotFoundException("Booking con ID " + id + " no encontrado");
        }

        Booking booking = existingBooking.get();
        if (bookingToSave.flightNumber() != null) booking.setFlightNumber(bookingToSave.flightNumber());
        if (bookingToSave.passengerName() != null) booking.setPassengerName(bookingToSave.passengerName());

        Booking updatedBooking = bookingRepository.save(booking);
        return bookingMapper.bookingToBookingDto(updatedBooking);
    }

    @Override
    public void deleteBooking(UUID id) throws BookingNotFoundException {
        Optional<Booking> bookingToDelete = bookingRepository.findById(id);

        if (bookingToDelete.isEmpty()) {
            throw new BookingNotFoundException("Booking con ID " + id + " no encontrado");
        }

        bookingRepository.deleteById(id);
    }
}
