package com.cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.model.Curso;
import com.cursos.repository.CursosRepository;

@Service("cursosService")
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosRepository cursosRepository;

	@Override
	public List<Curso> getAll() {
		return cursosRepository.findAll();
	}

	@Override
	public List<Curso> registerCursoAndGetAll(Curso curso) {
		cursosRepository.save(curso);
		return cursosRepository.findAll();
	}

	@Override
	public List<Curso> deleteCursoAndGetAll(String codCurso) {
		cursosRepository.deleteById(codCurso);
		return cursosRepository.findAll();
	}

	@Override
	public void updateDuracionCurso(String codCurso, int nuevaDuracion) {
		cursosRepository.updateDuracionById(codCurso, nuevaDuracion);
	}

	@Override
	public Curso getCurso(String codCurso) {
		return cursosRepository.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> getByPriceRange(double precioMin, double precioMax) {
		return cursosRepository.getByPriceRange(precioMin, precioMax);
	}
}
