package com.example.Team7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Team7.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer>{
}
