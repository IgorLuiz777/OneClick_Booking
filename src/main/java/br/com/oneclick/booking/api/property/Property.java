package br.com.oneclick.booking.api.property;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

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

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeProperty type;

    @NotNull
    private Integer roomsQuantity;

    @NotNull
    private Integer bedsQuantity;

    @NotNull
    @Column(name = "bathroomsQuantity")
    private Integer bathroomsQuantity;

    @Size(max = 500)
    private String description;

    @NotNull
    private BigDecimal dailyPrice;

    @Range(min = 1, max = 5)
    private int grade; // 1 - 5
}
