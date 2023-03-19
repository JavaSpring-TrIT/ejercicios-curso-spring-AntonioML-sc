package com.formacion.service;

import java.util.List;

import com.formacion.model.Formacion;

public interface FormacionService {

	List<Formacion> getAll();
	
	void register(Formacion formacion);
}
