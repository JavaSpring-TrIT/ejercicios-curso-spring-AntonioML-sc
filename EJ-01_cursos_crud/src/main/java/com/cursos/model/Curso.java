package com.cursos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tabla_cursos")
public class Curso {
	
	@Id
	@Column(name = "codCurso")
	private String codCurso;	

	@Column(name = "nombre")
	private String nombre;	

	@Column(name = "duracion")
	private int duracion;	

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
