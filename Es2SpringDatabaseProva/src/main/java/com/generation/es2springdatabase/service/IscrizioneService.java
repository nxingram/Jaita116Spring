package com.generation.es2springdatabase.service;

import org.springframework.stereotype.Service;

import com.generation.es2springdatabase.entity.Iscrizione;


public interface IscrizioneService {

	Iscrizione addOrUpdate(Iscrizione iscrizione);
}
