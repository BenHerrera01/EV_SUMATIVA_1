package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.repositories.CarritoRepository;

@Service
public class CarritoService {
	
	@Autowired
	CarritoRepository carritoRepository;
	
	public List<Carrito> listar(){
		return carritoRepository.findAll();
	}
	
	public void insertar(Carrito carrito) {
		carritoRepository.save(carrito);
	}
	
	public void editar(Carrito carrito) {
		carritoRepository.save(carrito);
	}
	
	public void eliminar(Carrito carrito) {
		carritoRepository.delete(carrito);
	}
	
	public Carrito obtenerCarritoUsuario(String email) {
		return carritoRepository.findByUserEmail(email);
	}
	
	public double obtenerTotal(List<Producto> productosCarrito) {
		double suma = 0.0;
		for (Producto producto : productosCarrito) {
			suma = suma + producto.getPrecio();
		}
		
		return suma;
	}
}
