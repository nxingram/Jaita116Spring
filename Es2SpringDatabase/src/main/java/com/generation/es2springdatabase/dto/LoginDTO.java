package com.generation.es2springdatabase.dto;

public class LoginDTO  {

	private String email;
	private String password;

	//il costruttore vuoto c'è sempre
	// a meno che non ci sia un altro costruttore
	// e allora lo devo aggiungere a mano
	
	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public LoginDTO() {
	
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
