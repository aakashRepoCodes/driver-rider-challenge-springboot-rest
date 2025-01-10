package com.hop.ride.model.auth;

import com.hop.ride.model.rider.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    @Autowired
    Rider rider;

    public UserPrincipal(Rider rider) {
        this.rider = rider;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return rider.getPassword();
    }

    @Override
    public String getUsername() {
        return rider.getUsername();
    }

    public Rider getRider() {
        return rider;
    }
}
