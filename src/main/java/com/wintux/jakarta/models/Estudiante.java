package com.wintux.jakarta.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Estudiante", schema="pregrado")
public class Estudiante implements Serializable{
	private static final long serialVersionUID = 4429896813291046282L;
	@Id
	private int Matricula;
	private String Nombre, Apellido;
	private Date FechaNacimiento;
	private String Password;
	private String Email;
	private Boolean Estado;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CarreraID")
	private Carrera carr;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="est", targetEntity=Inscripcion.class)
	private Set inscripciones;
	public void setCarrera(Carrera carrera) {
		this.carr = carrera;
	}
	public Carrera getCarrera() {
		return carr;
	}
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	@Column(name="Nombre", nullable=false,length=100)
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Column(name="Apellido", nullable=false,length=100)
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Column(name="FechaNacimiento", nullable=true)
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	@Column(name="Password", nullable=false)
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Column(name="Email", nullable=false)
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Column(name="Estado", nullable=false)
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	
}
