package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Create flight
        Flight testFlight = new Flight("Australia", 6,"12/12/23", "9:00");
        flightRepository.save(testFlight);

        Flight testFlightTwo = new Flight("Berlin", 2,"1/01/24", "4:00");
        flightRepository.save(testFlightTwo);

        //Create passengers
        Passenger passengerTom = new Passenger("Tom","tom@gmail.com");
        passengerRepository.save(passengerTom);
        passengerTom.addFlight(testFlight);

        Passenger passengerDaniel = new Passenger("Daniel","dan@gmail.com");
        passengerRepository.save(passengerDaniel);
        passengerDaniel.addFlight(testFlight);

        Passenger passengerJohn = new Passenger("John","mclaughlin@gmail.com");
        passengerRepository.save(passengerJohn);
        passengerJohn.addFlight(testFlight);





    }

}
