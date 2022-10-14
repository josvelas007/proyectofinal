package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Curso;
import com.example.demo.servicios.CursoService;

@Controller
public class CursoControlador {
	
	@Autowired
	private CursoService cursoServicio;
	
	@GetMapping("/siaG62")
	public String seleccionarCurso(Model model) {
		try {
			List<Curso> listaCursos = cursoServicio.findAll();
			model.addAttribute("cursos", listaCursos);			
		}catch(Exception e) {
			System.out.println("Error"+e.getCause());
		}
		
		return "/index";
	}
	
	@GetMapping("/nuevoCurso")
	public String addCurso(Model model) {
		model.addAttribute("cursos", new Curso());
		return "/addCurso";
	}
	
	@PostMapping("/saveCurso")
	public String addCurso(@Validated Curso curso) {
		System.out.println("Curso-->"+curso.toString());
		cursoServicio.save(curso);
		return "redirect:/siaG62";
	}
	
	@GetMapping("/mostrarCurso/{id}")
	public String mostrar(@PathVariable int id, Model model) {
		Optional<Curso> curso = cursoServicio.findById(id);
		model.addAttribute("curso", curso.get());
		return "/show";
	}
	
	@GetMapping("/borrarCurso/{id}")
	public String borrar(@PathVariable int id) {
		cursoServicio.deleteById(id);
		return "redirect:/siaG62";
	}
	
	
	@GetMapping("/nuevoEstudiante")
	public String addEstudiante(Model model) {
		try {
			List<Curso> listaCursos = cursoServicio.findAll();
			model.addAttribute("cursos", listaCursos);			
		}catch(Exception e) {
			System.out.println("Error"+e.getCause());
		}
		
		return "/addEstudiante";
	}
	

}
