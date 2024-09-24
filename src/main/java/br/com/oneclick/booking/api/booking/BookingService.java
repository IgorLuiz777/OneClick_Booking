package br.com.oneclick.booking.api.booking;

import br.com.oneclick.booking.api.auth.AuthService;
import br.com.oneclick.booking.api.auth.Token;
import br.com.oneclick.booking.api.auth.TokenService;
import br.com.oneclick.booking.api.property.Property;
import br.com.oneclick.booking.api.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private PropertyRepository propertyRepository;

    // TODO: BARRAR RESERVAS NA MESMA DATA
    // TODO: SOMAR PREÇO FINAL

    public Booking createBooking(Booking booking, String token) {
        if (bookingRepository.existsById(booking.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The ID is auto increment. Don't pass it in the request body!");
        }

        var user = tokenService.getUserFromToken(token);
        booking.setUser(user);

        var propertyId = booking.getProperty().getId();
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found"));

        booking.setProperty(property);

        var checkIn = booking.getCheckIn();
        var checkOut = booking.getCheckOut();
        var totalDays = Duration.between(checkIn, checkOut).toDays();
        var totalDaysBigDecimal = new BigDecimal(totalDays);
        var dailyPrice = property.getDailyPrice();
        var totalPrice = totalDaysBigDecimal.multiply(dailyPrice);
        booking.setTotalPrice(totalPrice);

        return bookingRepository.save(booking);
    }

    public List<Booking> listAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        if (!bookingRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Booking not found with id: " + id);
        return bookingRepository.findById(id);
    }

    public Booking updateBooking(Booking booking, Long id) {
        if (!bookingRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Booking not found with id: " + id);
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Booking not found with id: " + id);
        bookingRepository.deleteById(id);
    }

}
