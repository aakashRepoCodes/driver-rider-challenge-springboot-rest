package com.hop.ride.model.ride;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    Location location;

    String startAt;
    String endAt;

    @OneToOne
    RidePayment payment;

    boolean isSharedRide;

    String Status; //STARTED, ONGOING, COMPLETED, CANCELLED

    int rating;

}
