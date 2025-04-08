package com.wintux.jakarta.models;

import java.util.Set;

public class Asignatura {
	private String Sigla;
	private String Titulo;
	private String Descripcion;
	private Integer Creditos;
	private Carrera carrerita;
	public Carrera getCarrerita() {
		return carrerita;
	}
	private Set<Inscripcion> Inscripciones;
	
	public Set<Inscripcion> getInscripciones() {
		return Inscripciones;
	}
	public void setInscripciones(Set<Inscripcion> inscripciones) {
		Inscripciones = inscripciones;
	}
	public void setCarrerita(Carrera carrerita) {
		this.carrerita = carrerita;
	}
	public String getSigla() {
		return Sigla;
	}
	public void setSigla(String sigla) {
		Sigla = sigla;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Integer getCreditos() {
		return Creditos;
	}
	public void setCreditos(Integer creditos) {
		Creditos = creditos;
	}
}
