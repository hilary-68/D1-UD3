package com.example.demo;

import java.util.ArrayList;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Dato {
	
	private ArrayList<String> datos=new ArrayList<>();

	public ArrayList<String> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}

	public void add(String d) {
		this.datos.add(d);
	}
	
	
	
	
}
