package com.hop.ride.service;

import com.hop.ride.model.auth.UserPrincipal;
import com.hop.ride.model.request.LoginRequest;
import com.hop.ride.model.request.RiderDetailsUpdateRequest;
import com.hop.ride.model.rider.Rider;
import com.hop.ride.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

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

    public Rider updateRideDetails(RiderDetailsUpdateRequest request) {
       Rider existingRider = getCurrentRider();
       if (request.getUsername() != null) {
           existingRider.setUsername(request.getUsername());
       }
        if (request.getEmail() != null) {
            existingRider.setEmail(request.getEmail());
        }
        userRepository.save(existingRider);
        return existingRider;
    }

    public String deleteRider() {
        Rider existingRider = getCurrentRider();
        userRepository.deleteById(existingRider.getRiderId());
        return "Account deleted Successfully";
    }

    public Rider getCurrentRider() {
        UserPrincipal user = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getRider();
    }

}
