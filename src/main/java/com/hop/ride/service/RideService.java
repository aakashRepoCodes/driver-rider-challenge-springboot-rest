package com.hop.ride.service;

import com.hop.ride.NoRideFoundException;
import com.hop.ride.model.ride.Ride;
import com.hop.ride.repository.RideRepository;
import com.hop.ride.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    UserRepository userRepository;

    public String createRide(Ride ride) {
        ride.setStatus("CREATED");
        rideRepository.save(ride);
        return "Ride has been created";
    }

    public String startRide(Long rideId) {
        Ride exisitingRide =  getRideById(rideId);
        if (exisitingRide.getStatus().equals("CREATED")) {
           exisitingRide.setStatus("ONGOING");
           rideRepository.save(exisitingRide);
           return "Ride has been started now";
       } else {
           return "Cannot start ride because ride already exists";
       }
    }

    public String finishRide(Long rideId) {
        Ride exisitingRide =  getRideById(rideId);
        if (exisitingRide.getStatus().equals("ONGOING")) {
            exisitingRide.setStatus("COMPLETED");
            rideRepository.save(exisitingRide);
            return "Ride has been completed now";

        } else {
            return "Cannot complete the ride because ride already was not started";
        }
    }

    public String cancelRide(Long rideId) {
        Ride exisitingRide =  getRideById(rideId);
        if (exisitingRide.getStatus().equals("ONGOING")) {
            exisitingRide.setStatus("CANCELLED");
            rideRepository.save(exisitingRide);
            return "Ride has been cancelled now";

        } else {
            return "Cannot cancel the ride because ride already was never started";
        }
    }

    public List<Ride> getMyRides() {
        Long loggedInUserId = getCurrentUserId();
       // return rideRepository.findAllById(loggedInUserId);
        return Collections.emptyList();
    }

    private Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElseThrow(
                () -> new NoRideFoundException("No such ride found")
        );
    }

    private Long getCurrentUserId() {
        // to be extracted from AuthManager
        return 1L;
    }

}
