package com.example.Team7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Team7.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}
