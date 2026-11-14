package com.example.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Dato3 {
	
	@NotNull
	@Size(min=1, max=3)
	private String[] peliculas;
	
	public String[] getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(String[] peliculas) {
		this.peliculas = peliculas;
	}

}
