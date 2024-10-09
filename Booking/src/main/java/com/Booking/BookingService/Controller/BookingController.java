package com.Booking.BookingService.Controller;

import com.Booking.BookingService.Services.BookingService;
import com.Booking.BookingService.dto.Bookingmostrardto;
import com.Booking.BookingService.dto.Bookingtosalvedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping

    public ResponseEntity<Bookingtosalvedto> saveBooking(@RequestBody Bookingtosalvedto booking) {
        Bookingtosalvedto savedBooking = bookingService.saveBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Bookingmostrardto> updateBooking(@PathVariable("id") UUID id, @RequestBody Bookingtosalvedto booking) {
        Bookingmostrardto updatedBooking = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookingmostrardto> getBookingById(@PathVariable("id") UUID id) {
        Bookingmostrardto booking = bookingService.findBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Bookingmostrardto>> getAllBookings() {
        List<Bookingmostrardto> bookings = bookingService.findAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") UUID id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
