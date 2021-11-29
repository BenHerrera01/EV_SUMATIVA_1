package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, max = 15, message = "El nombre debe tener entre 3 y 15 caracteres")
	private String nombre;
	@Range(min = 1, max = 999999, message = "Precio fuera de rango")
	private Double precio;
	@Size(min = 3, max = 55, message = "La descripcion debe tener entre 3 y 15 caracteres")
	private String descripcion;
	@Size(min = 1, max = 20, message = "La marca debe tener entre 1 y 20 caracteres")
	private String marca;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "productos_carritos", 
			joinColumns = @JoinColumn(name = "producto_id"),
			inverseJoinColumns =  @JoinColumn(name = "carrito_id")
			)
	private List<Carrito> carritos;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "productos_categorias", 
			joinColumns = @JoinColumn(name = "producto_id"),
			inverseJoinColumns =  @JoinColumn(name = "categoria_id")
			)
	private List<Categoria> categorias;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	public Producto() {
	}

	public Producto(String nombre, Double precio, String descripcion, String marca) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.marca = marca;
	}



	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	
}
