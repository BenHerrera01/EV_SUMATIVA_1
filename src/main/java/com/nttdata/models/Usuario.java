package com.nttdata.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 3, max = 15, message = "El nombre debe tener entre 3 y 15 caracteres")
	private String nombre;
	@Size(min = 3, max = 15, message = "El apellido debe tener entre 3 y 15 caracteres")
	private String apellido;
	@Email(message = "Formato de correo invalido")
	private String email;
	@Range(min = 1, max = 99, message = "La edad debe estar entre 1 y 99 años")
	private Integer edad;
	
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	private String role;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Carrito carrito;
	
	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String email, Integer edad, String password, String role) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.password = password;
		this.role = role;
	}
	
	
	public Usuario(Long id,
			String nombre,
			String apellido,
			String email,
			Integer edad, String password,
			String role, String passwordConfirmation) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	


}
