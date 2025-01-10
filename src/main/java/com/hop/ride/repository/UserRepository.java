package com.hop.ride.repository;

import com.hop.ride.model.ride.Ride;
import com.hop.ride.model.rider.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Rider, Long> {

    List<Ride> findAllByRiderId(Long riderId);

    Optional<Rider> findByUsername(String username);

}
