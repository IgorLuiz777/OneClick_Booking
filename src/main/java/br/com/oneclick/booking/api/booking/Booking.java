package br.com.oneclick.booking.api.booking;

import br.com.oneclick.booking.api.property.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Property property;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private BigDecimal totalPrice;
}
