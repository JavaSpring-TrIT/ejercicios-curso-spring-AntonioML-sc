package com.cursos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Descripción de un curso de formación con su información básica")
@Entity
@Table(name = "tabla_cursos")
public class Curso {
	
	@Schema(description = "Código del curso - clave única")
	@Id
	@Column(name = "codCurso")
	private String codCurso;	

	@Schema(description = "Nombre del curso")
	@Column(name = "nombre")
	private String nombre;	

	@Schema(description = "Duración del curso en horas lectivas")
	@Column(name = "duracion")
	private int duracion;	

	@Schema(description = "Precio del curso en €")
	@Column(name = "precio")
	private double precio;

	public Curso() {
		super();
	}

	public Curso(String codCurso, String nombre, int duracion, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String getCodCurso() { return codCurso; }

	public void setCodCurso(String codCurso) { this.codCurso = codCurso; }

	public String getNombre() { return nombre; }

	public void setNombre(String nombre) { this.nombre = nombre; }

	public int getDuracion() { return duracion; }

	public void setDuracion(int duracion) { this.duracion = duracion; }

	public double getPrecio() { return precio; }
	
	public void setPrecio(double precio) { this.precio = precio; }
}
