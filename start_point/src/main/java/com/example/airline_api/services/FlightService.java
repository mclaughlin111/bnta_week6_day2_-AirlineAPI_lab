package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public void addFlight(Flight flight){flightRepository.save(flight);}

    public Flight findFlight(Long id){ return flightRepository.findById(id).get();}

    public Flight bookPassenger(Long flightId, Long passengerId){
        Flight flightToAdd = flightRepository.findById(flightId).get();
        //update attributes
        Passenger passengerToAdd = passengerRepository.findById(passengerId).get();

    }
}
