package com.example.Team7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Team7.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}
