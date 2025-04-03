package com.wintux.jakarta.models;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Estudiante", schema="pregrado")
public class Estudiante implements Serializable{
	@Id
	private int Matricula;
	private String Nombre, Apellido;
	private Date FechaNacimiento;
	private String Password;
	private String Email;
	private Boolean Estado;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CarreraID")
	private Carrera carr;
	public void setCarrera(Carrera carrera) {
		this.carr = carrera;
	}
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	
}
