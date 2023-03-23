package com.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.model.Formacion;
import com.formacion.service.FormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//INFO: localhost:9000/formacion/swagger-ui.html

@CrossOrigin("*")
@RestController
public class FormacionController {
	
	@Autowired
	@Qualifier("formacionService")
	FormacionService formacionService;
	
	@Operation(summary = "Devuelve una lista con todas las formaciones ofertadas")
	@ApiResponse(responseCode = "200", description = "Lista de formaciones recuperada")
	@GetMapping("getAll")
	@ResponseBody
	public List<Formacion> getAll() {
		return formacionService.getAll();
	}
	
	@Operation(summary = "Da de alta una nueva formación")
	@ApiResponse(responseCode = "200", description = "Nueva formación registrada")
	@PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void register(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Objeto JSON con los datos de la formación (ver modelo)",
					required = true,
					content = @Content(schema=@Schema(implementation = Formacion.class)))
			@RequestBody Formacion formacion) {
		formacionService.register(formacion);
	}
}
