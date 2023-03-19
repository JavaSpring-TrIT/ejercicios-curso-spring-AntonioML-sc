package com.cursos.service;

import java.util.List;

import com.cursos.model.Curso;

public interface CursosService {
	List<Curso> getAll();
	List<Curso> registerCursoAndGetAll(Curso curso);
	List<Curso> deleteCursoAndGetAll(String codCurso);
	void updateDuracionCurso(String codCurso, int nuevaDuracion);
	Curso getCurso(String codCurso);
	List<Curso> getByPriceRange(double precioMin, double precioMax);	
}
