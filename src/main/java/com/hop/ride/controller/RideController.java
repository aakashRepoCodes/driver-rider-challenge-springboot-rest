package com.hop.ride.controller;

import com.hop.ride.model.ride.Ride;
import com.hop.ride.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @PreAuthorize("hasRole('RIDER')")
    @PostMapping("/create")
    public String createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    @PreAuthorize("hasRole('RIDER')")
    @PostMapping("/start")
    public String startRide(@RequestParam Long rideId) {
        return rideService.startRide(rideId);
    }

    @PreAuthorize("hasRole('RIDER')")
    @PostMapping("/complete")
    public String finishRide(@RequestParam Long rideId) {
        return rideService.finishRide(rideId);
    }

    @PostMapping("/cancel")
    public String cancelRide(@RequestParam Long rideId) {
        return rideService.cancelRide(rideId);
    }

    @GetMapping("/my-rides")
    public List<Ride> getMyRides() {
        return rideService.getMyRides();
    }

}
