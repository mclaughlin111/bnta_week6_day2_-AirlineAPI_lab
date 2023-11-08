package com.example.airline_api.models;

import jakarta.persistence.Entity;

public class BookingDTO {

    private Long passengerId;

    public BookingDTO(){

    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
