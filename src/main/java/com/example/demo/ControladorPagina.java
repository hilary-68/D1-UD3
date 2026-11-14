package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPagina {
	
	@GetMapping("/")
	public String formulario1(HttpSession session, Model model) {
		Dato1 dato1 = (Dato1) session.getAttribute("dato1");
		if (dato1 == null) {
			dato1 = new Dato1();
		}
		model.addAttribute("dato1", dato1);
		return "formulario1";
	}
	
	@PostMapping("/")
	public String procesarFormulario1(@ModelAttribute("dato1") @Valid Dato1 dato1, BindingResult bindingResult,
			HttpSession session) {
		
		if (bindingResult.hasErrors()) {
			return "formulario1";
		}
		
		session.setAttribute("dato1", dato1);
		return "redirect:/formulario2";
	}

	@GetMapping("/formulario2")
	public String formulario2(HttpSession session, Model model) {
		if (session.getAttribute("dato1") == null) {
			return "redirect:/";
		}
		Dato2 dato2 = (Dato2) session.getAttribute("dato2");
		if (dato2 == null) {
			dato2 = new Dato2();
		}
		model.addAttribute("dato2", dato2);
		return "formulario2";
	}
	
	@PostMapping("/formulario2")
	public String procesarFormulario2(@ModelAttribute("dato2") @Valid Dato2 dato2, BindingResult bindingResult,
			HttpSession session) {
		
		if (session.getAttribute("dato1") == null) {
			return "redirect:/";
		}
		if (bindingResult.hasErrors()) {
			return "formulario2";
		}
		
		session.setAttribute("dato2", dato2);
		return "redirect:/formulario3";
	}
	
	@GetMapping("/formulario3")
	public String formulario3(HttpSession session, Model model) {
		if (session.getAttribute("dato1") == null) {
			return "redirect:/";
		}
		if (session.getAttribute("dato2") == null) {
			return "redirect:/formulario2";
		}
		Dato3 dato3 = (Dato3) session.getAttribute("dato3");
		if (dato3 == null) {
			dato3 = new Dato3();
		}
		model.addAttribute("dato3", dato3);
		return "formulario3";
	}
	
	@PostMapping("/formulario3")
	public String procesarFormulario3(@ModelAttribute("dato3") @Valid Dato3 dato3, BindingResult bindingResult,
			HttpSession session, Model model) {
		
		Dato1 dato1 = (Dato1) session.getAttribute("dato1");
		Dato2 dato2 = (Dato2) session.getAttribute("dato2");
		
		if (dato1 == null) {
			return "redirect:/";
		}
		if (dato2 == null) {
			return "redirect:/formulario2";
		}
		if (bindingResult.hasErrors()) {
			return "formulario3";
		}
		
		session.setAttribute("dato3", dato3);
		
		Dato datos = new Dato();
		datos.add("Nombre: " + dato1.getNombre());
		datos.add("Edad: " + dato1.getEdad());
		datos.add("Genero: " + dato2.getGenero());
		for (String p : dato3.getPeliculas()) {
			datos.add("Pelicula: " + p);
		}
		
		model.addAttribute("dato1", dato1);
		model.addAttribute("dato2", dato2);
		model.addAttribute("dato3", dato3);
		model.addAttribute("datos", datos);
		
		return "resultados";
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

