package com.example.airline_api.repositories;

import com.example.airline_api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    //find by destination
    List<Flight> findByDestination(String destination);
}
