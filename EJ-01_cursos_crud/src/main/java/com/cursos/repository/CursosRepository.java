package com.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cursos.model.Curso;

import jakarta.transaction.Transactional;

public interface CursosRepository extends JpaRepository<Curso, String>{

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE TABLA_CURSOS SET DURACION = :horas WHERE CODCURSO = :codCurso")
	void updateDuracionById(@Param("codCurso") String codCurso, @Param("horas") int horas);
	
	@Query("select c from Curso c where c.precio <= :precioMax and c.precio >= :precioMin order by c.precio")
	List<Curso> getByPriceRange(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);
}
