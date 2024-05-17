package com.generation.es2springdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.es2springdatabase.entity.Macchina;

@Repository
public interface MacchinaRepository extends JpaRepository<Macchina, Integer> {

}
