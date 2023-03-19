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

@CrossOrigin("*")
@RestController
public class FormacionController {
	
	@Autowired
	@Qualifier("formacionService")
	FormacionService formacionService;
	
	@GetMapping("getAll")
	@ResponseBody
	public List<Formacion> getAll() {
		return formacionService.getAll();
	}
	
	@PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void register(@RequestBody Formacion formacion) {
		formacionService.register(formacion);
	}
}
