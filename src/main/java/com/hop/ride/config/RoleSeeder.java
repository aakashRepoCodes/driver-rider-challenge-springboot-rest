package com.hop.ride.config;

import com.hop.ride.model.Role;
import com.hop.ride.repository.RoleRepository;
import com.hop.ride.repository.UserRepository;
import com.hop.ride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        boolean riderRoleExists = roleRepository.findRoleByRoleType("RIDER").isPresent();
        if (!riderRoleExists){
            Role role = new Role(null, "RIDER");
            roleRepository.save(role);
        }

        boolean driverRoleExists = roleRepository.findRoleByRoleType("DRIVER").isPresent();
        if (!riderRoleExists){
            Role role = new Role(null, "DRIVER");
            roleRepository.save(role);
        }
    }
}
