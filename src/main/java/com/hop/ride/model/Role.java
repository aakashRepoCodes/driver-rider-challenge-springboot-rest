package com.hop.ride.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String roleType;
}
