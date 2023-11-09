package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public void addFlight(Flight flight){flightRepository.save(flight);}

    public Flight findFlight(Long id){ return flightRepository.findById(id).get();}

    @Transactional
    public Flight bookPassenger(Long flightId, BookingDTO passengerId){
        Flight flightToAdd = flightRepository.findById(flightId).get();
        //update attributes

        Passenger passengerToAdd = passengerRepository.findById(passengerId.getPassengerId()).get();
        flightToAdd.addPassenger(passengerToAdd);
        flightRepository.save(flightToAdd); // Line added after solution review, not sure if needed 100%

        return flightToAdd;
    }

    @Transactional
    public void deleteFlight(Long id){flightRepository.deleteById(id);}

    public List<Flight> findAllFlightsByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }
}
