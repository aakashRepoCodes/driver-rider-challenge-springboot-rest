package com.hop.ride.controller;

import com.hop.ride.model.ride.Ride;
import com.hop.ride.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/create")
    public String createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    @PostMapping("/start")
    public String startRide(@RequestParam Long rideId) {
        return rideService.startRide(rideId);
    }

    @PostMapping("/complete")
    public String finishRide(@RequestParam Long rideId) {
        return rideService.finishRide(rideId);
    }

}