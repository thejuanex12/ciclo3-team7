package com.example.Team7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Team7.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
}
