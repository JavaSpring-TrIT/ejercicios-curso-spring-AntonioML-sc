package com.formacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacion.model.Curso;
import com.formacion.model.Formacion;

@Service("formacionService")
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	RestTemplate template;

	//private String url = "http://localhost:8080/cursos/";
	private String url = "http://servicio-cursos/cursos/";

	@Override
	public List<Formacion> getAll() {
		List<Curso> listaCursos;
		List<Formacion> listaFormacion = new ArrayList<>();
		
		listaCursos = Arrays.asList(template.getForObject(url + "getAll", Curso[].class));
		
		for (Curso curso:listaCursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getNombre());
			formacion.setAsignaturas(curso.getDuracion()>=50 ? 10 : 5);
			formacion.setPrecio(curso.getPrecio());
			
			listaFormacion.add(formacion);
		}
		
		return listaFormacion;
	}

	@Override
	public void register(Formacion formacion) {
		List<Curso> listaCursos;
		Curso nuevoCurso;

		listaCursos = Arrays.asList(template.getForObject(url + "getAll", Curso[].class));		
		listaCursos = listaCursos.stream().filter(curso -> curso.getNombre() == formacion.getCurso()).toList();
		
		if (listaCursos.size() == 0) {			
			nuevoCurso = new Curso();
			nuevoCurso.setNombre(formacion.getCurso());
			nuevoCurso.setDuracion(formacion.getAsignaturas() * 10);
			nuevoCurso.setPrecio(formacion.getPrecio());
			nuevoCurso.setCodCurso(formacion.getCurso().substring(0, 4) + nuevoCurso.getCodCurso());
			
			template.postForLocation(url + "register", nuevoCurso);
		}		
	}
}
