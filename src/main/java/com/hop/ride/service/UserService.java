package com.hop.ride.service;

import com.hop.ride.model.request.LoginRequest;
import com.hop.ride.model.ride.Ride;
import com.hop.ride.model.rider.Rider;
import com.hop.ride.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public List<Ride> getMyRides() {
        Long loggedInUserId = getCurrentUserId();
        return userRepository.findAllByRiderId(loggedInUserId);
    }

    private Long getCurrentUserId() {
        // to be extracted from AuthManager
        return 1L;
    }

    public String registerRider(Rider rider) {
        rider.setPassword(bCryptPasswordEncoder.encode(rider.getPassword()));
        userRepository.save(rider);
        return "success";
    }

    public String loginRider(LoginRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );
        if (authentication.isAuthenticated()) {
            return "success";
        } else
            return "Login failed";
    }
}
