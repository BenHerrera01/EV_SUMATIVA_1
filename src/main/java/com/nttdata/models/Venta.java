package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 15, message = "El nombre de venta debe tener entre 5 y 15 caracteres")
	private String nombre_venta;
	@Size(min = 8, max = 15, message = "La fecha debe tener un formato valido")
	private String fecha;
	@Size(min = 3, max = 15, message = "El cliente debe tener entre 3 y 15 caracteres")
	private String cliente;
	@Size(min = 3, max = 15, message = "El producto debe tener entre 3 y 15 caracteres")
	private String producto;

	public Venta() {
	}

	public Venta(Long id, String nombre_venta, String fecha, String cliente, String producto) {
		this.id = id;
		this.nombre_venta = nombre_venta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_venta() {
		return nombre_venta;
	}

	public void setNombre_venta(String nombre_venta) {
		this.nombre_venta = nombre_venta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
}
