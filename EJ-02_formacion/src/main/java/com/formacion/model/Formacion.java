package com.formacion.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información básica de un curso de formación")
public class Formacion {
	
	@Schema(description = "Nombre del curso")
	private String curso;
	
	@Schema(description = "Número de asignaturas")
	private int asignaturas;	

	@Schema(description = "Precio de la formación en €")
	private double precio;
	
	public Formacion() {
		super();
	}

	public Formacion(String curso, int asignaturas, double precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	public String getCurso() { return curso; }

	public void setCurso(String curso) { this.curso = curso; }

	public int getAsignaturas() { return asignaturas; }

	public void setAsignaturas(int asignaturas) { this.asignaturas = asignaturas; }

	public double getPrecio() { return precio; }

	public void setPrecio(double precio) { this.precio = precio; }
}
