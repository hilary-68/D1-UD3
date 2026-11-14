package com.example.demo;

import jakarta.validation.constraints.NotNull;

public class Prueba {
	
	@NotNull
	private String texto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
