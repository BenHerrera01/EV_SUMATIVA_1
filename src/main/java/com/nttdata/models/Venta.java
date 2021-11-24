package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre_venta;
	private String fecha;
	private String cliente;
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
