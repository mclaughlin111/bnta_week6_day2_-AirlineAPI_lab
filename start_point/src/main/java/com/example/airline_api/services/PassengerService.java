package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightService flightService;
    @Autowired
    FlightRepository flightRepository;

    //Fully Copied Method savePassenger
    public Passenger savePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());

        for (Long flightId : passengerDTO.getFlightIds()) {
            Flight flight = flightService.findFlight(flightId);
            passenger.addFlight(flight);
        }
        passengerRepository.save(passenger);
        return passenger;
    }

    // get all passengers
    public List<Passenger> getAllPassengers() {return passengerRepository.findAll();}


}
