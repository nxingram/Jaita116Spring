package com.generation.es2springdatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Macchina;
import com.generation.es2springdatabase.repository.MacchinaRepository;

import jakarta.transaction.Transactional;

@Service
public class MacchinaSericeImpl implements MacchinaService  {

	@Autowired
	MacchinaRepository macRepo;
	

	@Override
	@Transactional(rollbackOn = Exception.class)//così funziona!
	public Macchina save(Macchina macchina) throws Exception{
		macRepo.save(macchina);
		sendNotification();
		return macchina;
	}
	
	//metodo che lancia eccezione
    private void sendNotification() throws Exception {
    	throw new Exception("Notification sending is failed");
    }

}
