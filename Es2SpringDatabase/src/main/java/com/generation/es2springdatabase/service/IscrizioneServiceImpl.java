package com.generation.es2springdatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Iscrizione;
import com.generation.es2springdatabase.repository.IscrizioneRepository;

@Service
public class IscrizioneServiceImpl implements IscrizioneService {

	@Autowired
	IscrizioneRepository iscrRepo;
	
	@Override
	public Iscrizione addOrUpdate(Iscrizione iscrizione) {
		return iscrRepo.save(iscrizione);
	}

}
