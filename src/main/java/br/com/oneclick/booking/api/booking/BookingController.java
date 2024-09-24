package br.com.oneclick.booking.api.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking postBooking(@RequestBody Booking booking, @RequestHeader("Authorization") String token) {
        String bearerToken = token.startsWith("Bearer ") ? token.substring(7) : token;
        return bookingService.createBooking(booking, bearerToken);
    }

    @GetMapping
    public List<Booking> getAllBooking() {
        return bookingService.listAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/{id}")
    public Booking putBooking(@RequestBody Booking booking, @PathVariable Long id) {
        return bookingService.updateBooking(booking, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
