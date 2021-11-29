package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> listar(){
		return productoRepository.findAll();
	}
	
	public void agregar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void editar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void eliminar(Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Producto obtenerProducto(Long id) {
		return productoRepository.findById(id).get();
	}
	
	public List<Producto> obtenerPorCategoria(String categoria){
		return productoRepository.findByCategory(categoria);
	}
	
	public List<Producto> obtenerPorPalabraClave(String palabra){
		return productoRepository.findByKeyword(palabra);
	}
	
	public List<Producto> obtenerPorCategoriaDinamica(String nombreCategoria){
		return productoRepository.findByDynamicCategory(nombreCategoria);
	}
}
