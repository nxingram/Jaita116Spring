package com.generation.es2springdatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Macchina;
import com.generation.es2springdatabase.repository.MacchinaRepository;

@Service
public class MacchinaServiceImpl {

	@Autowired
	MacchinaRepository macRepo;
	
	public Macchina addOrUpdate(Macchina macchina)
	{
	 return macRepo.save(macchina);
	}
}
