package com.hop.ride.model.rider;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
