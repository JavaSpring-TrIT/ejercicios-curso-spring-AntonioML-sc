package com.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.model.Curso;
import com.cursos.service.CursosService;

@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	@Qualifier("cursosService")
	CursosService cursosService;
	
	@GetMapping(value = "getAll")
	@ResponseBody
	public List<Curso> getCursos() {
		return cursosService.getAll();
	}

	@PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> registerCurso(@RequestBody Curso curso) {
		return cursosService.registerCursoAndGetAll(curso);
	}

	@DeleteMapping(value = "delete/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> deleteCurso(@PathVariable("codCurso") String codCurso) {
		return cursosService.deleteCursoAndGetAll(codCurso);
	}	

	@PutMapping(value = "updateDuration")	
	public void updateBook(@RequestParam("id") String id, @RequestParam("horas") int horas) {
		cursosService.updateDuracionCurso(id, horas);
	}

	@GetMapping(value = "getCurso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso(@PathVariable("codCurso") String codCurso) {
		return cursosService.getCurso(codCurso);
	}	

	@GetMapping(value = "filterByPrecio", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursosEnRangoPrecios(@RequestParam("min") double min, @RequestParam("max") double max) {
		return cursosService.getByPriceRange(min, max);
	}
}
