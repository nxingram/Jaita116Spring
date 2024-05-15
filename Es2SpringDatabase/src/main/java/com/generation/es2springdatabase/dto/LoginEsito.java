package com.generation.es2springdatabase.dto;

import com.generation.es2springdatabase.entity.Persona;

public class LoginEsito {

	private Persona persona;
	private boolean esitoLogin;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isEsitoLogin() {
		return esitoLogin;
	}

	public void setEsitoLogin(boolean esitoLogin) {
		this.esitoLogin = esitoLogin;
	}

}
