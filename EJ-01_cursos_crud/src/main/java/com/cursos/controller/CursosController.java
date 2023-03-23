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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//INFO: localhost:8080/cursos/swagger-ui.html

@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	@Qualifier("cursosService")
	CursosService cursosService;
	
	@Operation(summary = "Devuelve una lista con todos los cursos ofertados")
	@ApiResponse(responseCode = "200", description = "Lista de cursos recuperada")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria", content = @Content())
	@GetMapping(value = "getAll")
	@ResponseBody
	public List<Curso> getCursos() {
		return cursosService.getAll();
	}


	@Operation(summary = "Da de alta un nuevo curso y devuelve la lista de todos los cursos")
	@ApiResponse(responseCode = "200", description = "Curso registrado")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria", content = @Content())
	@ApiResponse(responseCode = "403", description = "Usuario sin los privilegios necesarios", content = @Content())
	@PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> registerCurso(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Objeto JSON con los datos del curso (ver modelo)",
					required = true,
					content = @Content(schema=@Schema(implementation = Curso.class)))
			@RequestBody Curso curso) {		
		return cursosService.registerCursoAndGetAll(curso);
	}

	@Operation(summary = "Borra un curso y recupera la lista de los restantes")
	@ApiResponse(responseCode = "200", description = "Curso eliminado")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria", content = @Content())
	@ApiResponse(responseCode = "403", description = "Usuario sin los privilegios necesarios", content = @Content())
	@DeleteMapping(value = "delete/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> deleteCurso(@Parameter(description = "Código del curso", required = true) @PathVariable("codCurso") String codCurso) {
		return cursosService.deleteCursoAndGetAll(codCurso);
	}

	@Operation(summary = "Actualiza la duración de un curso")
	@ApiResponse(responseCode = "200", description = "Curso actualizado")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria")
	@ApiResponse(responseCode = "403", description = "Usuario sin los privilegios necesarios")
	@PutMapping(value = "updateDuration")	
	public void updateDuracionCurso(
			@Parameter(description = "Código del curso", required = true) @RequestParam("id") String id,
			@Parameter(description = "Nueva duración en horas", required = true) @RequestParam("horas") int horas) {
		cursosService.updateDuracionCurso(id, horas);
	}

	@Operation(summary = "Busca un curso por su código")
	@ApiResponse(responseCode = "200", description = "Curso recuperado")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria", content = @Content())
	@GetMapping(value = "getCurso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso(@Parameter(description = "Código del curso", required = true) @PathVariable("codCurso") String codCurso) {
		return cursosService.getCurso(codCurso);
	}	

	@Operation(summary = "Devuelve una lista de los cursos con precio comprendido entre dos valores dados")
	@ApiResponse(responseCode = "200", description = "Lista de cursos recuperada")
	@ApiResponse(responseCode = "401", description = "Autenticación necesaria", content = @Content())
	@GetMapping(value = "filterByPrecio", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursosEnRangoPrecios(
			@Parameter(description = "Precio mínimo", required = true) @RequestParam("min") double min,
			@Parameter(description = "Precio máximo", required = true) @RequestParam("max") double max) {
		return cursosService.getByPriceRange(min, max);
	}
}
