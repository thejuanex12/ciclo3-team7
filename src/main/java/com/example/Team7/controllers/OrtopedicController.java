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

import com.example.Team7.entities.Ortopedic;
import com.example.Team7.services.OrtopedicService;

@Service
@RestController
@RequestMapping("api/Ortopedic")
public class OrtopedicController {    

    @Autowired
    OrtopedicService ortopedicService;

    public OrtopedicController(OrtopedicService ortopedicService) {
        this.ortopedicService = ortopedicService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ortopedic>> getOrtopedics(){
        return new ResponseEntity<List<Ortopedic>>(this.ortopedicService.getListOrtopedic(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ortopedic> getOrtopedic(@PathVariable("id") int id){
        return new ResponseEntity<Ortopedic>(this.ortopedicService.getOrtopedic(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Ortopedic> crearOrtopedic(@RequestBody Ortopedic ortopedic){
        return new ResponseEntity<Ortopedic>(this.ortopedicService.crearOrtopedic(ortopedic), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOrtopedic(@PathVariable("id") int id){
        this.ortopedicService.eliminarOrtopedic(id);
        return new ResponseEntity<String>("Ortopedic Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizarOrtopedic(@RequestBody Ortopedic ortopedic){
        this.ortopedicService.actualizarOrtopedic(ortopedic.getId(), ortopedic);
        return new ResponseEntity<String>("Ortopedic Actualizado", HttpStatus.CREATED);
    }
    

}
