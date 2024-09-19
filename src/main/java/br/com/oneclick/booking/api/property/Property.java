package br.com.oneclick.booking.api.property;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeProperty type;

    private int roomsQuantity;

    private int bedsQuantity;

    private int bathroomsQuantity;

    private String description;

    private BigDecimal dailyPrice;

    private int grade; // 1 -5
}
