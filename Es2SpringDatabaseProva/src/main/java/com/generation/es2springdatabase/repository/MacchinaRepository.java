package com.generation.es2springdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.es2springdatabase.entity.Macchina;

public interface MacchinaRepository extends JpaRepository<Macchina, Integer> {

}
