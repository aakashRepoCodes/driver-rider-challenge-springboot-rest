package com.hop.ride.model.rider;

import com.hop.ride.model.ride.Ride;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rider {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long riderId;

    String username;
    String password;
    String email;

    int riderRating;

    @OneToMany
    List<Ride> ride;

}
