package io.lugonzo.unittesting108.model;

import io.lugonzo.unittesting108.enums.FlightType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    private String id;
    private String name;
    @Column(name = "flight_type")
    private FlightType flightType;
    @Column(name = "seat_no")
    private Long seatNo;

}
