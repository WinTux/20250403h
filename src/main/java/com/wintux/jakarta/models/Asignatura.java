package com.wintux.jakarta.models;

public class Asignatura {
	private String Sigla;
	private String Titulo;
	private String Descripcion;
	private Integer Creditos;
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
