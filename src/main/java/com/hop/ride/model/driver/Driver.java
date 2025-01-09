package com.hop.ride.model.driver;

import com.hop.ride.model.ride.Ride;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String password;
    String email;

    String isAvailable;

    @ManyToOne
    Ride ride;

    int driverRating;

}
