package com.hop.ride.service;

import com.hop.ride.NoRideFoundException;
import com.hop.ride.model.ride.Ride;
import com.hop.ride.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public String createRide(Ride ride) {
        ride.setStatus("CREATED");
        rideRepository.save(ride);
        return "Ride has been created";
    }

    public String startRide(Long rideId) {
       Ride exisitingRide =  rideRepository.findById(rideId).orElseThrow(
                () -> new NoRideFoundException("No such ride found")
        );
       if (exisitingRide.getStatus().equals("CREATED")) {
           exisitingRide.setStatus("STARTED");
           rideRepository.save(exisitingRide);
           return "Ride has been started now";

       } else {
           return "Cannot start ride because ride already exists";
       }

    }

    public String finishRide(Long rideId) {
        Ride exisitingRide =  rideRepository.findById(rideId).orElseThrow(
                () -> new NoRideFoundException("No such ride found")
        );
        if (exisitingRide.getStatus().equals("ONGOING") || exisitingRide.getStatus().equals("STARTED")) {
            exisitingRide.setStatus("COMPLETED");
            rideRepository.save(exisitingRide);
            return "Ride has been completed now";

        } else {
            return "Cannot complete the ride because ride already was not started";
        }
    }

}
