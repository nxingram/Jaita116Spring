package com.generation.es2springdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.es2springdatabase.entity.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Long> {

}
