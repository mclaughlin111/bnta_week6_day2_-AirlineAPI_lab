package com.example.airline_api.controllers;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlightsWithFilters(@RequestParam(required = false, name = "destination") String destination){

        //GET flights by destination
        if(destination != null){
            return new ResponseEntity<>(flightService.findAllFlightsByDestination(destination), HttpStatus.OK);
        }

        //GET all flights
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity(flightRepository.findById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long id, @RequestBody BookingDTO bookingPassenger){ // why can't this just be passing an INT for passenger id?

        Flight saveFlight = flightService.bookPassenger(id, bookingPassenger);

        return new ResponseEntity<>(saveFlight, HttpStatus.OK); // patch mapping delivers updated version of what you've just created
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(@PathVariable Long id){

        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
