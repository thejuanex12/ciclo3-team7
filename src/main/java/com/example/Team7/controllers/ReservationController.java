package com.example.Team7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Team7.entities.Reservation;
import com.example.Team7.services.ReservationService;

@Service
@RestController
@RequestMapping("api/Reservation")
public class ReservationController {    

    @Autowired
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<List<Reservation>>(this.reservationService.getListReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id){
        return new ResponseEntity<Reservation>(this.reservationService.getReservation(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Reservation> crearReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(this.reservationService.crearReservation(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReservation(@PathVariable("id") int id){
        this.reservationService.eliminarReservation(id);
        return new ResponseEntity<String>("Reservation Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizarReservation(@RequestBody Reservation reservation){
        this.reservationService.actualizarReservation(reservation.getId(), reservation);
        return new ResponseEntity<String>("Reservation Actualizado", HttpStatus.CREATED);
    }
    

}
