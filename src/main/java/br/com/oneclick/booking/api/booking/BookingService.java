package br.com.oneclick.booking.api.booking;

import br.com.oneclick.booking.api.property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // TODO: BARRAR RESERVAS NA MESMA DATA

    public Booking createBooking(Booking booking) {
        if (bookingRepository.existsById(booking.getId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "The ID is auto increment. Don't pass it in the request body!");
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
