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

import com.example.Team7.entities.Orthesis;
import com.example.Team7.services.OrthesisService;

@Service
@RestController
@RequestMapping("api/Orthesis")
public class OrthesisController {    

    @Autowired
    OrthesisService orthesisService;

    public OrthesisController(OrthesisService orthesisService) {
        this.orthesisService = orthesisService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Orthesis>> getOrthesiss(){
        return new ResponseEntity<List<Orthesis>>(this.orthesisService.getListOrthesis(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orthesis> getOrthesis(@PathVariable("id") int id){
        return new ResponseEntity<Orthesis>(this.orthesisService.getOrthesis(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Orthesis> crearOrthesis(@RequestBody Orthesis orthesis){
        return new ResponseEntity<Orthesis>(this.orthesisService.crearOrthesis(orthesis), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOrthesis(@PathVariable("id") int id){
        this.orthesisService.eliminarOrthesis(id);
        return new ResponseEntity<String>("Orthesis Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizarOrthesis(@RequestBody Orthesis orthesis){
        this.orthesisService.actualizarOrthesis(orthesis.getId(), orthesis);
        return new ResponseEntity<String>("Orthesis Actualizado", HttpStatus.CREATED);
    }
    

}
