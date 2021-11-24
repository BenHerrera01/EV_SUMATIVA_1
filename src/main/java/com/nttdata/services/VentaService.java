package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Venta;
import com.nttdata.repositories.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	VentaRepository ventaRepository;
	
	public List<Venta> listar(){
		return ventaRepository.findAll();
	}
	
	public void agregar(Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void editar(Venta venta) {
		ventaRepository.save(venta);
	}
	
	public void eliminar(Venta venta) {
		ventaRepository.delete(venta);
	}
	
	public Venta obtenerVenta(Long id) {
		return ventaRepository.findById(id).get();
	}
}
