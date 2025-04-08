package com.wintux.jakarta.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Carrera",schema="pregrado")
public class Carrera implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CarreraID;
	private String Nombre;
	private String Edificio;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="carr", targetEntity=Estudiante.class)
	private Set estudiantes;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="carrerita", targetEntity=Asignatura.class)
	private Set asignaturas;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="carr", targetEntity=Docente.class)
	private Set docentes;
	public Set getDocentes() {
		return docentes;
	}
	public void setDocentes(Set docentes) {
		this.docentes = docentes;
	}
	public Set getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Set asignaturas) {
		this.asignaturas = asignaturas;
	}
	public Set getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(Set estudiantes) {
		this.estudiantes = estudiantes;
	}
	@Column(name="CarreraID", nullable=false)
	public int getCarreraID() {
		return CarreraID;
	}
	public void setCarreraID(int carreraID) {
		CarreraID = carreraID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEdificio() {
		return Edificio;
	}
	public void setEdificio(String edificio) {
		Edificio = edificio;
	}
	
}
