package com.hop.ride.controller;

import com.hop.ride.model.request.LoginRequest;
import com.hop.ride.model.request.RiderDetailsUpdateRequest;
import com.hop.ride.model.rider.Rider;
import com.hop.ride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rider")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Rider rider) {
        return userService.registerRider(rider);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginRider(request);
    }

    @PatchMapping("/update")
    public Rider updateRiderDetails(@RequestBody RiderDetailsUpdateRequest request) {
        return userService.updateRideDetails(request);
    }

    @DeleteMapping("/delete")
    public String deleteMyAccount() {
        return userService.deleteRider();
    }

}
